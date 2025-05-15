/*📚 Sistema de Gerenciamento de Clube de Leitura
Um clube de leitura universitário deseja informatizar a gestão de suas atividades, incluindo o cadastro de membros, organização de encontros, registro de livros lidos e recomendações de leitura. O sistema deve ser capaz de registrar:

    Os membros do clube, com seus dados pessoais e histórico de leituras.

    Os livros lidos ou recomendados por diferentes membros.

    Os encontros realizados pelo clube, com informações como data, tema e participantes.

    A associação entre livros e encontros, permitindo saber quais livros foram discutidos em cada encontro.

    Estatísticas gerais, como o número total de membros cadastrados e o livro mais recomendado.

Você deve projetar e implementar um sistema orientado a objetos completo, que atenda às necessidades descritas acima.*/

import java.util.ArrayList;

class Club {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Meeting> meetings = new ArrayList<>();
    

    public static void main(String[] args){
        Book livro1 = new Book();
        books.add(livro1);
        Book livro2 = new Book();
        books.add(livro2);

        Member cleitinho = new Member("998", "cleitinho");
        Member cleitinho2 = new Member("991", "cleitinaa");
        Meeting encontro1 = new Meeting("19/03", "oi", cleitinho.getId());
        meetings.add(encontro1);

        encontro1.setParticipants(1);

        System.out.println(encontro1.getDate());
        System.out.println(encontro1.getParticipants());
    }
}