/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pcego.ia.genetico.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Pcego
 */
public class Calculos {

    // declaração variáveis
    private static final int CONSTANTE = 100000; // constante para calcular FA roleta
    private static int cont;
    private static int valor1, valor2, valor3; // variáveis para armazenar valor de cada palavra
    public static char[] letras = new char[10];  // vetor para controle dos valores de cada letra
    private static int index = 0;  // variável para controle do indice no método para calculo dos valores das palavras
    private int soma = 0; // variável para somatório

    // método para gerar população inicial
    public Individuo geraPopulacao(String p1, String p2, String p3) {

        int fa;
        int fa_roleta;
        // vetor para representar indivíduo
        String[] vet = {"10", "10", "10", "10", "10", "10", "10", "10", "10", "10"};
        Random r = new Random();
        Individuo ind = new Individuo();

        // loop para gerar indivíduo
        for (int i = 0; i < 10; i++) {

            int num = geraRandom(10);
            // trabalhando com string para valores de 0 a 9
            vet[i] = String.valueOf(num);

            if (i > 0) {
                for (cont = 0; cont < i; cont++) {
                    // condição para evitar numeros repetidos
                    if (String.valueOf(num).equals(vet[cont])) {
                        i--;
                    }

                }
            }

        }

        // avaliação do individuo
        fa = calculaFa(p1, p2, p3, vet);

        // roleta individuo
        fa_roleta = calculaFaRoleta(fa);

        ind.setIndividuo(vet);
        ind.setFa(fa);
        ind.setFa_roleta(fa_roleta);
        ind.setSomatorio(soma += ind.getFa_roleta());

        return ind;

    }

    // método para o calcula da FA
    // recebe como parametro as palavras e o individuo
    public int calculaFa(String p1, String p2, String p3, String[] vet) {
        int fa = -1; // inicialização com valor negativo para tratar possível erro

        // zerando vetor com valores de cada letra
        for (int h = 0; h < 10; h++) {
            letras[h] = '0';
        }
        index = 0;

        // chamada ao método para calculo do valor de cada palavra
        valor1 = retornaValor(p1, vet);
        valor2 = retornaValor(p2, vet);
        valor3 = retornaValor(p3, vet);

        fa = (valor1 + valor2) - valor3;
        // condiçao para evitar FA negativa
        if (fa < 0) {
            fa *= (-1);
        }

        return fa;
    }

    // método para calcular valor da palavra
    // recebe como parametro a palavra e o individuo
    public int retornaValor(String p, String[] vet) {

        int count;
        String valor = "0";

        //indice do individuo
        for (int j = 0; j < p.length(); j++) {//rodar a palavra

            count = 1;
            for (int x = 0; x < 10; x++) {//loop letras

                // verificando se a letra da palavra
                // ja existe existe no vetor de letras
                if (p.charAt(j) == letras[x]) {
                    break;
                } else {
                    count++;//se não é igual, incrementa Count  
                }
            }
            // count == 11, todo vetor foi verificado
            // portanto a letra não se repete no vetor            
            if (count == 11) {
                // adicionando letra ao vetor na posição index
                letras[Integer.parseInt(vet[index])] = p.charAt(j);
                index++;
            }
        }

        // loop para calcular o valor da palavra
        // baseado no indice onde as letras da palavra estão
        // ex: letra b esta na posição 8, então b vale 8
        // em seguida se concatena para obter o valor da palavra
        for (int y = 0; y < p.length(); y++) {
            for (int f = 0; f < 10; f++) {
                if (p.charAt(y) == letras[f]) {
                    valor += String.valueOf(f);
                }
            }

        }

        return Integer.parseInt(valor);
    }

    // método para calcular FA Roleta
    // recebe a FA do individuo como parametro
    public int calculaFaRoleta(int f) {
        double faRoleta;

        if (f == 0) {
            return f;

        } else {
            // formula para calculo da FA Roleta
            faRoleta = (1.0 / f) * CONSTANTE;
        }
        return (int) faRoleta;
    }

    // gerar numero randomico
    // recebe numero positivo e inteiro 
    public int geraRandom(int n) {
        int num;
        Random r = new Random();
        num = r.nextInt(n);
        return num;
    }

    // seleção de individuos por Roleta
    // recebe somatório (maxSoma), taxa de crossover (cross) e lista de individuos
    public ArrayList<Individuo> geraSelecao(int maxSoma, int cross,
            ArrayList<Individuo> list) {

        ArrayList<Individuo> lst = new ArrayList<>();
        Random r = new Random();
        lst.clear();

        // calculo da quantidade de individuos a serem selecionados
        int tamanho = (cross * list.size()) / 100;

        // condição somente para torneio
        if (cross == 2) {
            tamanho = 2;
        } else if (cross == 3) {
            tamanho = 3;
        }

        // loop para seleção por roleta
        for (int i = 0; i < tamanho; i++) {

            int num = r.nextInt(maxSoma + 1);

            for (int j = 0; j < list.size(); j++) {
                // condição para verificar individuos
                if (list.get(j).getSomatorio() >= num) {

                    // condiçao para não repetir individuo durante a seleção
                    if (lst.contains(list.get(j))) {
                        i--;
                        break;
                    }
                    lst.add(list.get(j));
                    break;
                }
            }

        }

        return lst;
    }

    // seleção por truncamento (melhor FA)
    // recebe cross (taxa de crossover), lista da população
    public ArrayList<Individuo> geraSelecaoTruncad(int cross,
            ArrayList<Individuo> listTruncad) {

        ArrayList<Individuo> aux = new ArrayList<>();
        ArrayList<Individuo> lista = new ArrayList<>();
        lista = (ArrayList<Individuo>) listTruncad.clone();
        Collections.sort(lista); //chamada ao quick sort para ordenar lista por FA

        // loop para selecionar individuos de acordo com a taxa de crossover
        for (int i = 0; i < ((cross * listTruncad.size()) / 100); i++) {
            aux.add(lista.get(i));
        }
        return aux;
    }

    // seleção torneio simples
    // recebe taxa crossover (cross), lista de individuos e tipo de torneio
    public ArrayList<Individuo> geraSelecaoTorneioSimples(int cross,
            ArrayList<Individuo> lista, int torneio) {

        ArrayList<Individuo> tor = new ArrayList<>();
        ArrayList<Individuo> select = new ArrayList<>();
        Random r = new Random();

        int indice;
        int tamanho = lista.size();
        //loop seleção
        for (int x = 0; x < ((cross * tamanho) / 100); x++) {
            tor.clear();
            indice = 0;

            // loop para selecionar individuo de acordo co
            // o tipo de torneio de 2 ou 3
            for (int i = 0; i < torneio; i++) {
                // gera numero randomico
                int num = r.nextInt(lista.size());

                // adicionando individuos dois ou tres
                // dependendo do torneio
                tor.add(lista.get(num));
            }

            // calcula do individuo de menor fa entre os selecionados
            int menor = tor.get(0).getFa();

            for (int j = 1; j < tor.size(); j++) {

                if (menor > tor.get(j).getFa()) {
                    menor = tor.get(j).getFa();
                    indice = j;
                }
            }
            if (select.contains(tor.get(indice))) { // verifica repetição de individuo
                x--;
            } else {
                select.add(tor.get(indice)); // adiciona a lista a ser retornada
            }

        }
        return select;
    }

    // seleção por torneio estocástico
    // recebe somatório, taxa crossover, tipo torneio 2 ou 3
    public ArrayList<Individuo> geraSelecaoTorneioEst(int maxSoma, int cross,
            ArrayList<Individuo> lista, int torneio) {

        ArrayList<Individuo> tor = new ArrayList<>();
        ArrayList<Individuo> select = new ArrayList<>();

        int indice;
        int tamanho = lista.size();

        for (int x = 0; x < ((cross * tamanho) / 100); x++) {
            tor.clear();
            indice = 0;
            // seleção por roleta
            tor = geraSelecao(maxSoma, torneio, lista);
            // tor.add(lista.get(num));

            int menor = tor.get(0).getFa();

            for (int j = 1; j < tor.size(); j++) {

                if (menor > tor.get(j).getFa()) {
                    menor = tor.get(j).getFa();
                    indice = j;
                }
            }

            if (select.contains(tor.get(indice))) {
                x--;
            } else {
                select.add(tor.get(indice));
            }
        }

        return select;
    }

    /*
     * CRUZAMENTO PMX
     * 
     * 
     * 2 Pontos de corte Fixo entre 1 e 9 <>
     * 
     * EX:        | CORTES  | 
     *  P1  5 9 1 | 8 0 7 6 | 2 3 4        MATRIZ DE TROCA (CENTRO)
     *  P2  6 9 1 | 5 0 8 2 | 7 3 4        8-5
     *                                     0-0 
     *  F1  5 9 1 | 5 0 8 2 | 2 3 4        7-8 
     *  F1  6 9 1 | 8 0 7 6 | 7 3 4        6-2
     * 
     * Realiza trocas de reptição (fora do centro) com base na matriz de troca
     * 
     *      7
     *      8                 6
     *  F1  5 9 1 | 5 0 8 2 | 2 3 4         
     *  F1  6 9 1 | 8 0 7 6 | 7 3 4 
     *      2                 8
     *                        5
     * 
     * RESULTADO APÓS TROCA
     * 
     *  F1  7 9 1 | 5 0 8 2 | 6 3 4         
     *  F1  2 9 1 | 8 0 7 6 | 5 3 4
     * 
     */
    public ArrayList<Individuo> geraCruzamentoPmx(ArrayList<Individuo> select) {

        ArrayList<Individuo> cruzamento, clone;
        ArrayList<String> trava;
        Individuo pai, mae, f1, f2;
        String[] trocaPai, trocaMae;
        int contador = 1;
        int troca = 0;
        trocaPai = new String[4]; // vetor de troca
        trocaMae = new String[4]; // vetor de troca
        cruzamento = new ArrayList<>();
        clone = new ArrayList<>();
        trava = new ArrayList<>(); // trava para evitar loop infinito

        clone = Serialization.copy(select); // cloanando array sem referencia

        // loop seleção individuos para cruzamento
        for (int i = 0; i < clone.size(); i += 2) {
            int corte1 = 3; // ponto de corte do pmx
            int corte2 = 6;
            troca = 0;

            pai = clone.get(i);
            mae = clone.get(contador);
            f1 = Serialization.copy(pai); // clonagem
            f2 = Serialization.copy(mae);
            int y = 0;

            // loop para gerar matriz de troca
            // e troca genetica dos filhos
            for (int x = corte1; x <= corte2; x++) {
                trocaPai[y] = pai.getIndividuo()[x];
                trocaMae[y] = mae.getIndividuo()[x];
                f1.getIndividuo()[x] = mae.getIndividuo()[x];
                f2.getIndividuo()[x] = pai.getIndividuo()[x];
                y++;
            }

            // loop para iniciar cruzamento            
            for (int r = corte1; r <= corte2; r++) {
                for (int f = 0; f < 10; f++) {
                    // condição para preservar nucleo de troca
                    if (f >= corte1 && f <= corte2) {
                        continue;
                    }
                    // cruzamento e validação do individuo
                    if (f1.getIndividuo()[r].equals(f1.getIndividuo()[f])) {
                        for (int t = 0; t < 4; t++) {
                            if (trocaPai[t].equals(f1.getIndividuo()[f]) && !trava.contains(trocaMae[t])) {
                                f1.getIndividuo()[f] = trocaMae[t];
                                troca = 1;
                                trava.add(trocaPai[t]); // trava validação
                                trava.add(trocaMae[t]);
                                t = 0;
                            }
                        }

                    }

                    if (troca == 0) {
                        for (int t = 0; t < 4; t++) {
                            if (trocaMae[t].equals(f1.getIndividuo()[f]) && !trava.contains(trocaPai[t])) {
                                f1.getIndividuo()[f] = trocaPai[t];
                                trava.add(trocaPai[t]);
                                trava.add(trocaMae[t]);
                                troca = 0;
                                t = 0;
                            }

                        }
                    }

                }

            }

            trava.clear();
            troca = 0;

            // idem anterior para individuo filho 2
            for (int r = corte1; r <= corte2; r++) {
                for (int f = 0; f < 10; f++) {
                    if (f >= corte1 && f <= corte2) {
                        continue;
                    }
                    if (f2.getIndividuo()[r].equals(f2.getIndividuo()[f])) {
                        for (int t = 0; t < 4; t++) {
                            if (trocaPai[t].equals(f2.getIndividuo()[f]) && !trava.contains(trocaMae[t])) {
                                f2.getIndividuo()[f] = trocaMae[t];
                                troca = 1;
                                trava.add(trocaPai[t]);
                                trava.add(trocaMae[t]);
                                t = 0;
                            }
                        }

                    }

                    if (troca == 0) {
                        for (int t = 0; t < 4; t++) {
                            if (trocaMae[t].equals(f2.getIndividuo()[f]) && !trava.contains(trocaPai[t])) {
                                f2.getIndividuo()[f] = trocaPai[t];
                                trava.add(trocaPai[t]);
                                trava.add(trocaMae[t]);
                                troca = 0;
                                t = 0;
                            }

                        }
                    }

                }
            }
            trava.clear();
            troca = 0;
            cruzamento.add(f1);
            cruzamento.add(f2);
            contador += 2;
        }
        return cruzamento;
    }

    // cruzamento ciclico
    public ArrayList<Individuo> geraCruzamentoCiclico(ArrayList<Individuo> select) {

        ArrayList<Individuo> cruzamento, clone;
        Individuo pai, mae, f1, f2;
        int contador = 1;
        int posicao = 0;
        String troca = null, primeiroGene = null;
        cruzamento = new ArrayList<>();
        clone = new ArrayList<>();

        clone = Serialization.copy(select);


        for (int i = 0; i < clone.size(); i += 2) {

            posicao = geraRandom(10);
            pai = clone.get(i);
            mae = clone.get(contador);
            f1 = Serialization.copy(pai);
            f2 = Serialization.copy(mae);
            // controle gene inicial
            primeiroGene = f1.getIndividuo()[posicao];
            troca = f2.getIndividuo()[posicao]; // valor de troca entre individuos

            // loop para controlar fim do cruzamento
            while (!primeiroGene.equals(troca)) {
                int ok = 0;
                int indice = 0;

                // loop para cruzar individuos
                for (int t = 0; t < 10; t++) {

                    if (t == posicao) {
                        continue;
                    }
                    if (f1.getIndividuo()[t].equals(troca)) {
                        indice = t;
                        ok = 1;
                        break;
                    }

                }

                f2.getIndividuo()[posicao] = f1.getIndividuo()[posicao];
                f1.getIndividuo()[posicao] = troca;

                posicao = indice;
                troca = f2.getIndividuo()[posicao];

                if (ok == 0) {
                    break;
                }

            }

            f2.getIndividuo()[posicao] = f1.getIndividuo()[posicao];
            f1.getIndividuo()[posicao] = troca;

            cruzamento.add(f1);
            cruzamento.add(f2);
            contador += 2;
        }

        return cruzamento;

    }

    // método de reinserção por elite
    // escolhe o individuo de melhor FA e gira a roleta para o restante
    public ArrayList<Individuo> reinsercaoRoletaElite(ArrayList<Individuo> populacao) {

        ArrayList<Individuo> clone;
        clone = new ArrayList<>();
        clone = Serialization.copy(populacao);
        populacao.clear();
        int indice = 0;
        soma = 0;

        Iterator<Individuo> i = clone.listIterator();
        while (i.hasNext()) {
            Individuo ind;
            ind = i.next();
            soma += ind.getFa_roleta();
            ind.setSomatorio(soma);
        }

        int menor = clone.get(0).getFa();

        for (int j = 1; j < clone.size(); j++) {

            if (menor > clone.get(j).getFa()) {
                menor = clone.get(j).getFa();
                indice = j;
            }
        }
        Individuo aux = clone.get(indice);
        clone.remove(clone.get(indice));
        populacao = geraSelecao(soma, 62, clone);
        populacao.add(aux);

        return populacao;
    }

    // reinserção pura, ordena por FA e seleciona os primeiros de
    // acordo com o tamanho da populaçao
    public ArrayList<Individuo> reinsercaoPura(ArrayList<Individuo> lst, int pop) {

        lst = geraSelecaoTruncad(100, lst);

        for (int i = pop + 1; i < lst.size(); i++) {
            lst.remove(i);
        }
        return lst;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }

    public int getSoma() {
        return this.soma;
    }

    public static void setIndex(int index) {
        Calculos.index = index;
    }

    public int mediaFaPop(ArrayList<Individuo> lista) {
        Individuo ind = new Individuo();
        double mediaFa = 0;
        double somaFa = 0;

        Iterator<Individuo> i = lista.listIterator();
        while (i.hasNext()) {
            ind = i.next();
            somaFa += ind.getFa();

        }
        mediaFa = (somaFa / lista.size());

        return (int) mediaFa;
    }

    public Individuo calculaMenorFa(ArrayList<Individuo> lst) {

        int indice = 0;
        int menor = lst.get(0).getFa();

        for (int j = 1; j < lst.size(); j++) {

            if (menor > lst.get(j).getFa()) {
                menor = lst.get(j).getFa();
                indice = j;
            }
        }
        return lst.get(indice);
    }

    public ArrayList<Individuo> mutação(ArrayList<Individuo> lst, int taxa) {
        int num, aux;
        String tr = null;

        for (int h = 0; h < (taxa * lst.size() / 100); h++) {
            num = geraRandom(lst.size() + 1);
            lst.get(num).getIndividuo();           
            
        }
        return null;


    }
}
