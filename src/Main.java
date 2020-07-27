import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Game solitaire = new Game();
        System.out.println("Campo di gioco: \n "+solitaire.toString());
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Eccoti il menu del programma:\n1 prendi una carta\n2 sposta una carta dal mazzo alla griglia\n3 sposti le carte dentro la griglia\n4 sposti le carte dal mazzo alla griglia finale\n5 sposti le carte dalla griglia di gioco a quella finale\n6 Ricomincia la partita");
            int destRow, destCol, startRow, startCol, choose=0;
            //Try catch per lo switch case
            try{
                choose = input.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Errore input!");
                input.next(); //pulisce lo scanner
            }
            switch (choose) {
                //Prende e mostra 1 carta dal deck
                case 1:
                    solitaire.pickCard();
                    System.out.println("Campo di gioco:\n"+solitaire.toString());
                break;
                //Dal deck al campo
                case 2:
                    try {
                        System.out.println("Inserisci riga");
                        destRow = input.nextInt();
                        System.out.println("Inserisci colonna");
                        destCol = input.nextInt();
                        solitaire.moveCardFromDeck(destRow, destCol);
                        System.out.println(solitaire.toString());
                    }catch (InputMismatchException e){
                        input.next();
                        System.out.println("Errore nell'input");
                    }


                break;
                //Spostamento carte all'interno del campo
                case 3:
                    try {
                        System.out.println("Inserisci riga della carta che vuoi selezionare");
                        startRow = input.nextInt();
                        System.out.println("Inserisci colonna della carta che vuoi selezionare");
                        startCol = input.nextInt();
                        System.out.println("Inserisci riga di destinazione");
                        destRow = input.nextInt();
                        System.out.println("Inserisci colonna di destinazione");
                        destCol = input.nextInt();
                        solitaire.moveCards(startRow,startCol,destRow,destCol);
                        System.out.println(solitaire.toString());
                    }catch (InputMismatchException e){
                        input.next();
                        System.out.println("Errore nell'input");
                    }
                break;
                //Dal deck alla griglia finale
                case 4:
                    try {
                        System.out.println("Inserisci colonna della griglia finale");
                        destCol = input.nextInt();
                        solitaire.moveFromDeckToFinalDecks(destCol);
                        System.out.println(solitaire.toString());
                    }catch (InputMismatchException e){
                        input.next();
                        System.out.println("Errore nell'input");
                    }
                break;
                //Dalla griglia di gioco alla griglia finale
                case 5:
                    try {
                        System.out.println("Inserisci riga della carta che vuoi selezionare");
                        startRow = input.nextInt();
                        System.out.println("Inserisci colonna della carta che vuoi selezionare");
                        startCol = input.nextInt();
                        System.out.println("Inserisci colonna della griglia finale");
                        destCol = input.nextInt();
                        solitaire.moveCardToFinalDecks(startRow,startCol,destCol);
                        System.out.println("Campo di gioco:\n"+solitaire.toString());
                    }catch (InputMismatchException e){
                        input.next();
                        System.out.println("Errore nell'input");
                    }
                    break;
                //Reset della partita
                case 6:
                    solitaire=new Game();
                    System.out.println("Campo di gioco:\n"+solitaire.toString());
                break;
                case 7:
                    System.out.println("Grazie di aver giocato!");
                    System.exit(0);
                break;
                //Default nel caso di input erronei
                default:
                    System.out.println("Qualcosa è andato storto");
                break;

            }
        }while (solitaire.win());
        System.out.println("Congratulazioni hai vinto!");
    }
}
