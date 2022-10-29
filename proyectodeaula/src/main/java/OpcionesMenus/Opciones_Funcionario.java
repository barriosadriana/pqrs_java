
package OpcionesMenus;

import modelo.proyectodeaula.Controladores.UsuarioController;

public class Opciones_Funcionario {
    public void opcionesFuncionario(int opcion){
        UsuarioController menu = new UsuarioController();
        switch (opcion) {
                case 1 :
                    menu.mostrarSolicitudes(opcion);
                    break;
                case 2 :
                    menu.responderSolicitudes(opcion);
                    break;
                case 3 :
                    menu.mostrarReportes(opcion);
                    break;
                case 4 :
                    System.out.println("----Finalizado con exito----");
                    break;
                default :
                    System.out.println("----Opcion Incorrecta----");
                    break;
            }

    }
}
