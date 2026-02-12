package linketinder.view

import java.util.Scanner

class MenuView {

    private static final Scanner scanner = new Scanner(System.in)

    static int mostrarMenu() {
        println "\n=== LINKETINDER ==="
        println "1 - Listar candidatos"
        println "2 - Listar empresas"
        println "0 - Sair"
        print "Escolha:"

        return scanner.nextInt()
    }
}
