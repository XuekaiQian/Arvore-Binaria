package com.mycompany.arvore;

public class ArvBi {

    private Node inicio;

    public ArvBi() {
        inicio = null; 
    }

    public void insert(int data) {
        Node novoNode = new Node(data);
        if (inicio == null) {
            inicio = novoNode;
            return;
        }

        Node atual = inicio;
        Node pai;
        while (true) {
            pai = atual;
            if (data < atual.getValor()) {
                atual = atual.getEsquerda();
                if (atual == null) {
                    pai.setEsquerda(novoNode);
                    return;
                }
            } else {
                atual = atual.getDireita();
                if (atual == null) {
                    pai.setDireita(novoNode);
                    return;
                }
            }
        }
    }

    public void printEmOrdem() {
        if (inicio == null) {
            System.out.println("Árvore vazia");
            return;
        }

        Node atual = inicio;

        while (atual != null) {
            if (atual.getEsquerda() == null) {
                System.out.print(atual.getValor() + " ");
                atual = atual.getDireita();
            } else {
                Node predecessor = atual.getEsquerda();
                while (predecessor.getDireita() != null && predecessor.getDireita() != atual) {
                    predecessor = predecessor.getDireita();
                }

                if (predecessor.getDireita() == null) {
                    predecessor.setDireita(atual);
                    atual = atual.getEsquerda();
                } else {
                    predecessor.setDireita(null);
                    System.out.print(atual.getValor() + " ");
                    atual = atual.getDireita();
                }
            }
        }

        System.out.println();
    }

    public void removeMaior() {
        if (inicio == null) {
            return; 
        }

        Node pai = null;
        Node atual = inicio;

        while (atual.getDireita() != null) {
            pai = atual;
            atual = atual.getDireita();
        }

        if (pai == null) {
            inicio = atual.getEsquerda();
        } else {
            pai.setDireita(atual.getEsquerda());
        }
    }

    public void removeMenor() {
        if (inicio == null) {
            return; // Árvore vazia
        }

        Node pai = null;
        Node atual = inicio;

        while (atual.getEsquerda() != null) {
            pai = atual;
            atual = atual.getEsquerda();
        }

        if (pai == null) {
            inicio = atual.getDireita();
        } else {
            pai.setEsquerda(atual.getDireita());
        }
    }

    private int getMenorValor(Node inicio) {
        int menorValor = inicio.getValor();
        while (inicio.getEsquerda() != null) {
            menorValor = inicio.getEsquerda().getValor();
            inicio = inicio.getEsquerda();
        }
        return menorValor;
    }

    public void printPreOrdem() {
        printPreOrdemRec(inicio);
        System.out.println();
    }

    private void printPreOrdemRec(Node node) {
        if (node != null) {
            System.out.print(node.getValor() + " ");
            printPreOrdemRec(node.getEsquerda());
            printPreOrdemRec(node.getDireita());
        }
    }

    public void printPosOrdem() {
        printPosOrdemRec(inicio);
        System.out.println();
    }

    private void printPosOrdemRec(Node node) {
        if (node != null) {
            printPosOrdemRec(node.getEsquerda());
            printPosOrdemRec(node.getDireita());
            System.out.print(node.getValor() + " ");
        }
    }

    public void remove(int valor) {
      inicio = removeRec(inicio, valor);
    }

    private Node removeRec(Node atual, int valor) {

      if (atual == null)
          return null;

      if (valor < atual.getValor()) 
          atual.setEsquerda(removeRec(atual.getEsquerda(), valor));
      else if(valor > atual.getValor())
          atual.setDireita(removeRec(atual.getDireita(), valor));
      else {

          if(atual.getLeft()==null && node.getRight()==null)
              return null;

          else if(atual.getRight()==null)
              return atual.getLeft();

          else if(atual.getLeft()==null)
              return node.getRight();

          int minValue = minValue(atual.getRight());
          atual.setValor(minValue);

          atual.setDireita(removeRec(atual.getDireita(), minValue));
      }
      return atual;
    }

    private int minValue(Node node) {

        if(node.getLeft() != null)
            return minValue(node.getLeft());

        return node.getValor();
    }
}
