/*📚 Sistema de Gerenciamento de Clube de Leitura
Um clube de leitura universitário deseja informatizar a gestão de suas atividades, incluindo o cadastro de membros, organização de encontros, registro de livros lidos e recomendações de leitura. O sistema deve ser capaz de registrar:

    Os membros do clube, com seus dados pessoais e histórico de leituras.

    Os livros lidos ou recomendados por diferentes membros.

    Os encontros realizados pelo clube, com informações como data, tema e participantes.

    A associação entre livros e encontros, permitindo saber quais livros foram discutidos em cada encontro.

    Estatísticas gerais, como o número total de membros cadastrados e o livro mais recomendado.

Você deve projetar e implementar um sistema orientado a objetos completo, que atenda às necessidades descritas acima.*/

import java.util.ArrayList;
import java.util.Iterator;

class Club {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Meeting> meetings = new ArrayList<>();
    private static Book mostRecommendedBook;
    private static int numberOfMembers = 0;

    public static Book getMostRecommendedBook(){
        Iterator<Book> booksIterator = books.iterator();
        Book candidateMostRecommended = booksIterator.next();
        while (booksIterator.hasNext()) {
            Book currentBook = booksIterator.next();
            if (currentBook.getRecomendations() > candidateMostRecommended.getRecomendations()) {
                candidateMostRecommended = currentBook;
            }
            System.out.println(currentBook.getTitle());
        }

        mostRecommendedBook = candidateMostRecommended;
        return mostRecommendedBook;
    }

    public static void main(String[] args){
        Book livro1 = new Book();
        books.add(livro1);
        livro1.setTitle("titulo 1");
        Book livro2 = new Book();
        books.add(livro2);
        livro2.setTitle("titulo 2");
        Book livro3 = new Book();
        books.add(livro3);
        livro3.setTitle("titulo 3");

        Member cleitinho = new Member("998", "cleitinho"); numberOfMembers++;
        Member cleitinho2 = new Member("991", "cleitinaa"); numberOfMembers++;
        Meeting encontro1 = new Meeting("19/03", "oi", cleitinho.getId());
        meetings.add(encontro1);

        encontro1.setParticipants(1);
        getMostRecommendedBook();

        System.out.println(encontro1.getDate());
        System.out.println(encontro1.getParticipants());
        System.out.println(numberOfMembers);
    }
}
