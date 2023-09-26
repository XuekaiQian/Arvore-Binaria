package com.mycompany.arvore;

public class Main {

    public static void main(String[] args) {
        ArvBi arvore = new ArvBi();

        arvore.insert(50);
        arvore.insert(30);
        arvore.insert(20);
        arvore.insert(40);
        arvore.insert(70);
        arvore.insert(60);
        arvore.insert(80);

        System.out.println("Impressão em pré-ordem:");
        arvore.printPreOrdem();

        System.out.println("Impressão em ordem:");
        arvore.printEmOrdem();

        System.out.println("Impressão em pós-ordem:");
        arvore.printPosOrdem();

        System.out.println("Removendo o maior elemento...");
        arvore.removeMaior();
        arvore.printEmOrdem();

        System.out.println("Removendo o menor elemento...");
        arvore.removeMenor();
        arvore.printEmOrdem();

        System.out.println("Removendo o elemento 40...");
        arvore.remove(40);
        arvore.printEmOrdem();
    }
}
