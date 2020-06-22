/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.coti.tools.Esdia.readString;
import static com.coti.tools.Esdia.yesOrNo;
import controller.Controller;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class View {

    Controller c = new Controller();
    Scanner sc = new Scanner(System.in);

    public void runMenu(String menu) throws Exception {

        boolean salir = false;

        c.arranque();

        do {
            String option;
            String[] avaiableOptions = {"1", "2", "3", "4", "5", "6", "q"};

            option = readString(menu, avaiableOptions);

            switch (option) {
                case "1":
                    this.generarAleatorios();
                    break;
                case "2":
                    this.archivos();
                    break;
                case "3":
                    this.album();
                    break;
                case "4":
                    this.artista();
                    break;
                case "5":
                    this.playlist();
                    break;
                case "6":
                    this.canciones();
                    break;
                case "q":
                    c.salida();
                    salir = yesOrNo("Desea realmente salir?:");
                    break;
                default:
                    out.printf("%n%nOpción Incorrecta%n%n");
                    break;
            }
        } while (!salir);
    } // End of method runMenu()

    private void generarAleatorios() {
        c.cargarAleatorios();
    }

    private void archivos() {
        String menuArchivos = "\n"
                + "==================== EXPORTAR =====================\n"
                + "Seleccione que archivos quiere exportar:\n"
                + "1.- Exportar artistas con formato de columnas\n"
                + "2.- Exportar albumes con formato de tabla html\n"
                + "v.- Volver al menu\n"
                + "===================================================\n"
                + "Opciones -> ";

        boolean volver = false;

        do {
            String option;
            String[] avaiableOptions = {"1", "2", "v"};

            option = readString(menuArchivos, avaiableOptions);

            switch (option) {
                case "1":
                    c.artistasEnColumnas();
                    break;
                case "2":
                    c.albumesEnHTML();
                    break;
                case "v":
                    volver = true;
                    break;
                default:
                    out.printf("%n%nOpción Incorrecta%n%n");
                    break;
            }
        } while (!volver);
    }

    private void album() {
        String menuAlbumes = "\n"
                + "================= ALBUMES =================\n"
                + "1.- Altas\n"
                + "2.- Bajas\n"
                + "3.- Modificaciones\n"
                + "4.- Consulta\n"
                + "v.- Volver al menu\n"
                + "===========================================\n"
                + "Opciones -> ";

        boolean volver = false;

        do {
            String option;
            String[] avaiableOptions = {"1", "2", "3", "4", "v"};

            option = readString(menuAlbumes, avaiableOptions);

            switch (option) {
                case "1":
                    System.out.printf("%nDAR DE ALTA");
                    boolean volver1 = false;
                    do {
                        String subMenu1 = "\n1.- Añadir un album a musicfy"
                                + "\nv. Volver al menu de Albumes\n";
                        String option1;
                        String[] avaiableOptions1 = {"1", "v"};

                        option1 = readString(subMenu1, avaiableOptions1);

                        switch (option1) {
                            case "1":
                                String[] atributos = new String[10];
                                int[] annoDuracionNumCanciones = new int[4];
                                String tmp;

                                boolean atributoCorrecto = false;

                                // Introducimos el título del Álbum
                                do {
                                    System.out.printf("%nTítulo del álbum: ");
                                    atributos[0] = sc.nextLine();

                                    if (atributos[0].isEmpty()) {
                                        System.out.printf("%nEl campo título no puede quedar vacio%n");
                                    }
                                } while (atributos[0].isEmpty());

                                // Introducimos el interprete del Álbum
                                do {
                                    System.out.printf("%nIntérprete/s (Separados por ; si hay más de uno): ");
                                    atributos[1] = sc.nextLine();
                                    if (atributos[1].isEmpty()) {
                                        System.out.println("El director no puede quedar vacío");
                                    }
                                } while (atributos[1].isEmpty());

                                // Introducimos el año del Álbum
                                do {
                                    System.out.printf("%nAño: ");
                                    tmp = sc.nextLine();
                                    if (tmp.isEmpty()) {
                                        atributoCorrecto = true;
                                    } else {
                                        try {
                                            annoDuracionNumCanciones[0] = Integer.parseInt(tmp);
                                            atributoCorrecto = true;
                                        } catch (NumberFormatException ex) {
                                            System.out.printf("%nEl año debe ser un número válido");
                                        }
                                    }
                                } while (!atributoCorrecto);

                                atributoCorrecto = false;

                                // Introducimos la duración del Álbum
                                do {
                                    System.out.printf("%nDuración: ");
                                    System.out.printf("%nMinutos: ");
                                    tmp = sc.nextLine();
                                    if (tmp.isEmpty()) {
                                        atributoCorrecto = true;
                                    } else {
                                        try {
                                            annoDuracionNumCanciones[1] = Integer.parseInt(tmp);
                                            atributoCorrecto = true;
                                        } catch (NumberFormatException ex) {
                                            System.out.printf("%nLa duración debe ser un número valido");
                                        }
                                    }
                                } while (!atributoCorrecto);

                                atributoCorrecto = false;

                                do {
                                    System.out.printf("%nSegundos: ");
                                    tmp = sc.nextLine();
                                    if (tmp.isEmpty()) {
                                        atributoCorrecto = true;
                                    } else {
                                        try {
                                            annoDuracionNumCanciones[2] = Integer.parseInt(tmp);
                                            atributoCorrecto = true;
                                        } catch (NumberFormatException ex) {
                                            System.out.printf("%nLa duración debe ser un número valido");
                                        }
                                    }
                                } while (!atributoCorrecto);

                                atributoCorrecto = false;

                                // Introducimos el número de canciones del Álbum
                                do {
                                    System.out.printf("%nNº de canciones: ");
                                    tmp = sc.nextLine();
                                    if (tmp.isEmpty()) {
                                        atributoCorrecto = true;
                                    } else {
                                        try {
                                            annoDuracionNumCanciones[3] = Integer.parseInt(tmp);
                                            atributoCorrecto = true;
                                        } catch (NumberFormatException ex) {
                                            System.out.printf("%nEl nº de canciones debe ser un número válido");
                                        }
                                    }
                                } while (!atributoCorrecto);

                                // Introducimos el tipo de Álbum
                                do {
                                    System.out.printf("%nTipo de álbum: ");
                                    atributos[2] = sc.nextLine();
                                    if (atributos[2].isEmpty()) {
                                        System.out.printf("%nEl campo tipo de álbum no puede quedar vacío");
                                    }
                                } while (atributos[2].isEmpty());

                                // Introducimos las canciones del Álbum
                                do {
                                    System.out.printf("Canciones: ");
                                    atributos[3] = sc.nextLine();
                                    if (atributos[3].isEmpty()) {
                                        System.out.printf("%nEl campo canciones no puede estar vacío");
                                    }
                                } while (atributos[3].isEmpty());

                                c.añadirAlbum(atributos, annoDuracionNumCanciones);

                                System.out.printf("%n%nSe ha añadido correctamente el álbum%n%n");
                                break;
                            case "v":
                                volver1 = true;
                                break;
                        }//End of switch (option1)
                    } while (!volver1);
                    break;
                case "2":
                    System.out.printf("%nDAR DE BAJA");
                    boolean volver2 = false;
                    do {
                        String subMenu2 = "\n1.- Buscar álbum a eliminar"
                                + "\nv.- Volver al menu de Albumes\n";
                        String option2;
                        String[] avaiableOptions2 = {"1", "v"};

                        option2 = readString(subMenu2, avaiableOptions2);

                        switch (option2) {
                            case "1":
                                System.out.printf("%nIntroduce el álbum que quieres borar: ");
                                String album = sc.nextLine();
                                int i = c.busquedaAlbum(album);
                                if (i == -1) {
                                    System.out.printf("%nEl album no se ha encontrado%n");
                                } else {
                                    c.borrarAlbum(i);
                                    System.out.printf("%nEl album se ha eliminado correctamente%n");
                                }
                                break;
                            case "v":
                                volver2 = true;
                                break;
                        } //End of switch (option2)

                    } while (!volver2);
                    break;
                case "3":
                    System.out.printf("%nMODIFICAR UN ALBUM");
                    boolean volver3 = false;
                    do {
                        String subMenu3 = "\n1.-Buscar álbum a modificar"
                                + "\nv. Volver al menu de Albumes";
                        String option3;
                        String[] avaiableOptions3 = {"1", "v"};

                        option3 = readString(subMenu3, avaiableOptions3);

                        switch (option3) {
                            case "1":
                                boolean subVolver = false;
                                System.out.printf("%nIntroduce el álbum que quieres modificar: ");
                                String album = sc.nextLine();
                                int i = c.busquedaAlbum(album);
                                if (i == -1) {
                                    System.out.printf("%nEl album no se ha encontrado%n");
                                } else {
                                    do {
                                        System.out.printf("Elige el campo que quieres modificar: "
                                                + "%n1.- Año"
                                                + "%n2.- Duración"
                                                + "%n3.- Nº de canciones"
                                                + "%n4.- Tipo"
                                                + "%nv.- Volver");
                                        String subOption = sc.nextLine();
                                        switch (subOption) {
                                            case "1":
                                            case "2":
                                            case "3":
                                            case "4":
                                                int iSubOption = Integer.parseInt(subOption);
                                                String[] atributo = {"Año", "Duración", "Nº de canciones",
                                                    "Tipo"};
                                                boolean comprobacion;
                                                do {
                                                    System.out.printf("Introduce un nuevo valor para" + atributo[iSubOption - 1] + ": ");
                                                    String nuevoCampo = sc.nextLine();
                                                    comprobacion = c.modificarAlbum(iSubOption, i, nuevoCampo);
                                                    if (true == comprobacion) {
                                                        System.out.printf("%nSe ha modificado correctamente%n");
                                                    } else {
                                                        System.out.printf("%nNo se ha podido modificar%n");
                                                    }
                                                } while (!comprobacion);
                                                break;
                                            case "v":
                                                subVolver = true;
                                                break;
                                            default:
                                                System.out.printf("%n%nOpción Incorrecta%n%n");
                                        } //End of switch (subOption)
                                    } while (!subVolver);
                                }
                                break;
                            case "v":
                                volver3 = true;
                                break;
                        }
                    } while (!volver3);
                    break;
                case "4":
                    System.out.printf("%nCONSULTAR UN ALBUM");
                    boolean volver4 = false;
                    do {
                        String subMenu = "\n1.- Consultar un álbum"
                                + "\nv.- Volver";
                        String option4;
                        String[] avaiableOptions4 = {"1", "v"};

                        option4 = readString(subMenu, avaiableOptions4);

                        switch (option4) {
                            case "1":
                                System.out.printf("%nIntroduce el álbum que quieres consultar: ");
                                String album = sc.nextLine();
                                String consulta = c.consultaAlbumes(album);
                                if (consulta == null) {
                                    System.out.printf("%nEl álbum que ha introducido no se ha encontrado%n");
                                } else {
                                    System.out.printf(consulta);
                                }
                                break;
                            case "v":
                                volver4 = true;
                                break;
                        } //End of switch (option4)
                    } while (!volver4);
                    break;

                case "v":
                    volver = true;
                    break;
                default:
                    System.out.printf("%n%nOpción Incorrecta%n%n");
            } //End of switch (option)
        } while (!volver);
    } //End of method album()

    private void artista() {
        String menuArtistas = "\n"
                + "================= ARTISTAS ================="
                + "\n1.- Altas"
                + "\n2.- Bajas"
                + "\n3.- Modificaciones"
                + "\n4.- Albumes de un artista"
                + "\nv.- Volver al menu principal"
                + "\n==========================================="
                + "\nOpciones -> ";

        boolean volver = false;

        do {

            String option;

            String[] avaiableOptions = {"1", "2", "3", "4", "v"};

            option = readString(menuArtistas, avaiableOptions);

            switch (option) {
                case "1":
                    System.out.printf("%nDAR DE ALTA");
                    boolean volver1 = false;
                    do {
                        String subMenu1 = "\n1.- Añadir artista a musicfy"
                                + "\nv.- Volver al menu de artistas";

                        String option1;
                        String[] avaiableOptions1 = {"1", "v"};

                        option1 = readString(subMenu1, avaiableOptions1);

                        switch (option1) {
                            case "1":
                                String[] atributos = new String[8];

                                // Introducimos el nombre del artista
                                do {
                                    System.out.printf("%nNombre: ");
                                    atributos[0] = sc.nextLine();
                                    if (atributos[0].isEmpty()) {
                                        System.out.printf("%nEl campo nombre no puede quedar vacío%n");
                                    }
                                } while (atributos[0].isEmpty());

                                // Introducimos la biografía del artista
                                do {
                                    System.out.printf("%nBiografía: ");
                                    atributos[1] = sc.nextLine();
                                    if (atributos[1].isEmpty()) {
                                        System.out.printf("%nEl campo biografía no puede quedar vacío");
                                    }
                                } while (atributos[1].isEmpty());

                                // Introducimos el instagram del artista
                                do {
                                    System.out.printf("%nInstagram: ");
                                    atributos[2] = sc.nextLine();
                                    if (atributos[2].isEmpty()) {
                                        System.out.printf("%nEl campo instagram no puede quedar vacío");
                                    }
                                } while (atributos[2].isEmpty());

                                // Introducimos el twitter del artista
                                do {
                                    System.out.printf("%nTwitter: ");
                                    atributos[3] = sc.nextLine();
                                    if (atributos[3].isEmpty()) {
                                        System.out.printf("%nEl campo twitter no puede quedar vacío");
                                    }
                                } while (atributos[3].isEmpty());

                                // Introducimos el Facebook del artista
                                do {
                                    System.out.printf("%nFacebook: ");
                                    atributos[4] = sc.nextLine();
                                    if (atributos[4].isEmpty()) {
                                        System.out.printf("%nEl campo facebook no puede quedar vacío");
                                    }
                                } while (atributos[4].isEmpty());

                                // Introducimos el link de Wikipedia del artista
                                do {
                                    System.out.printf("%nLink de su página en Wikipedia: ");
                                    atributos[5] = sc.nextLine();
                                    if (atributos[5].isEmpty()) {
                                        System.out.printf("%nEl campo Ref-Wikipedia no puede quedar vacío");
                                    }
                                } while (atributos[5].isEmpty());

                                // Introducimos la coleccion de albumes del artista
                                do {
                                    System.out.printf("%nÁlbum/es (Separados por ; si hay más de uno): ");
                                    atributos[6] = sc.nextLine();
                                    if (atributos[6].isEmpty()) {
                                        System.out.printf("%nEl campo albumes no puede quedar vacío");
                                    }
                                } while (atributos[6].isEmpty());

                                c.añadirArtista(atributos);
                                System.out.printf("%n%nSe ha añadido correctamente el artista%n%n");
                                break;
                            case "v":
                                volver1 = true;
                                break;
                        }
                    } while (!volver1);
                    break;
                case "2":
                    System.out.printf("%nBAJAS");
                    boolean volver2 = false;
                    do {
                        String subMenu2 = "\n1.- Buscar artista a eliminar"
                                + "\nv.- Volver al menu de artistas";
                        String option2;
                        String[] avaiableOptions2 = {"1", "v"};

                        option2 = readString(subMenu2, avaiableOptions2);

                        switch (option2) {
                            case "1":
                                System.out.printf("%nIntroduce el artista que quieres borrar: ");
                                String artista = sc.nextLine();
                                int i = c.busquedaArtista(artista);

                                if (i == -1) {
                                    System.out.printf("%nEl artista que ha introducido no se ha encontrado%n");
                                } else {
                                    c.borrarArtista(i);
                                }
                                break;

                            case "v":
                                volver2 = true;
                                break;
                        }
                    } while (!volver2);
                    break;
                case "3":
                    System.out.printf("%nMODIFICACIONES");
                    boolean volver3 = false;
                    do {
                        String subMenu3 = "\n1.- Buscar artista a modificar"
                                + "\nv.- Volver al menu de artistas";
                        String option3;
                        String[] avaiableOptions3 = {"1", "v"};

                        option3 = readString(subMenu3, avaiableOptions3);

                        switch (option3) {
                            case "1":
                                boolean subVolver = false;
                                System.out.printf("%nIntroduce un artista para modificar: ");
                                String artista = sc.nextLine();
                                int i = c.busquedaArtista(artista);
                                if (i == -1) {
                                    System.out.printf("%nEl artista que ha introducido no se ha encontrado%n");
                                } else {
                                    do {
                                        System.out.printf("%nElige el campo que quieres modificar:"
                                                + "%n1.- Biografía"
                                                + "%n2.- Instagram"
                                                + "%n3.- Twitter"
                                                + "%n4.- Facebook"
                                                + "%n5.- Wikipedia"
                                                + "%nv.- Volver");
                                        String subOption = sc.nextLine();
                                        switch (subOption) {
                                            case "1":
                                            case "2":
                                            case "3":
                                                int iSubOption = Integer.parseInt(subOption);
                                                String[] atributo = {"Biografía", "Instagram", "Twitter",
                                                    "Facebook", "Wikipedia"};
                                                boolean comprobacion;
                                                do {
                                                    System.out.printf("%nIntroduce un nuevo valor para" + atributo[iSubOption - 1] + ": ");
                                                    String nuevoCampo = sc.nextLine();
                                                    comprobacion = c.modificarArtista(iSubOption, i, nuevoCampo);
                                                    if (true == comprobacion) {
                                                        System.out.printf("%nSe ha modificado correctamente%n");
                                                    } else {
                                                        System.out.printf("%nNo se ha podido modificar");
                                                    }
                                                } while (!comprobacion);
                                                break;

                                            case "v":
                                                subVolver = true;
                                                break;
                                            default:
                                                System.out.printf("%n%nOpción Incorrecta%n%n");
                                        }
                                    } while (!subVolver);
                                }
                                break;
                            case "v":
                                volver3 = true;
                                break;
                        }
                    } while (!volver3);
                    break;
                case "4":
                    System.out.printf("%nALBUMES DE UN ARTISTA");
                    boolean volver4 = false;
                    do {
                        String subMenu4 = "\n1.- Buscar los albumes de un artista"
                                + "\nv.- Volver al menu de artistas";
                        String option4;
                        String[] avaiableOptions4 = {"1", "v"};

                        option4 = readString(subMenu4, avaiableOptions4);

                        switch (option4) {
                            case "1":
                                System.out.printf("%nIntroduce el artista del que quieres saber sus albumes: ");
                                String artista = sc.nextLine();
                                int i = c.busquedaArtista(artista);
                                if (i == -1) {
                                    System.out.printf("%n El artista introducido no se ha encontrado%n");
                                } else {
                                    String[] albumes = c.albumesArtista(i);
                                    if (null == albumes) {
                                        System.err.println("\nError: No ha sido posible obtener el listado de albumes\n");
                                        return;
                                    }
                                    for (String s : albumes) {
                                        System.out.printf("%s%n", s);
                                    }
                                }
                                break;
                            case "v":
                                volver4 = true;
                                break;
                        }
                    } while (!volver4);
                    break;
                case "v":
                    volver = true;
                    break;
                default:
                    System.out.printf("%n%nOpción Incorrecta%n%n");
            }
        } while (!volver);
    }

    private void playlist() {
        String menuPlaylist = "\n"
                + "\n============== PLAYLIST =============="
                + "\n1.- Altas"
                + "\n2.- Eliminar canción"
                + "\n3.- Añadir canción"
                + "\nv.- Volver al menu principal"
                + "\n======================================"
                + "\nOpciones ->";

        boolean volver = false;

        do {
            String option;
            String[] avaiableOptions = {"1", "2", "3", "v"};

            option = readString(menuPlaylist, avaiableOptions);

            switch (option) {
                case "1":
                    String[] playlist = new String[2];
                    int[] num_canciones_p = new int[2];
                    String tmp;
                    boolean atributoCorrecto = false;

                    // Introducimos el nombre de la Playlist
                    do {
                        System.out.printf("%nNombre: ");
                        playlist[0] = sc.nextLine();
                        if (playlist[0].isEmpty()) {
                            System.out.printf("%nEl campo nombre no puede quedar vacío%n");
                        }
                    } while (playlist[0].isEmpty());

                    // Introducimos el nº de canciones de la PlayList
                    do {
                        System.out.printf("%nNº de canciones: ");
                        tmp = sc.nextLine();

                        if (tmp.isEmpty()) {
                            atributoCorrecto = true;
                        } else {
                            try {
                                num_canciones_p[0] = Integer.parseInt(tmp);
                                atributoCorrecto = true;
                            } catch (NumberFormatException ex) {
                                System.out.printf("%n%nEl número de canciones tiene que ser un número entero%n");
                            }

                        }
                    } while (!atributoCorrecto);
                    c.añadirPlaylist(playlist, num_canciones_p);
                    System.out.printf("%n%nSe ha añadido correctamente una Playlist%n%n");
                    break;
                case "2":
                    String subMenu1 = "\n\nELIMINAR CANCIÓN DE LA PLAYLIST"
                            + "\n1.- Buscar la canción a eliminar"
                            + "\nv.- Volver";
                    boolean volver1 = false;

                    do {
                        String option1;
                        String[] avaiableOptions1 = {"1", "v"};

                        option1 = readString(subMenu1, avaiableOptions1);

                        switch (option1) {
                            case "1":
                                System.out.printf("%nIntroduce el titulo de una playlist: ");
                                String tituloPlaylist = sc.nextLine();
                                int i = c.busquedaPlaylist(tituloPlaylist);
                                if (-1 == i) {
                                    System.out.printf("%nLa playlist que has introducido no se ha podido encontrar%n");
                                } else {
                                    String[] cancionesPlaylist = c.cancionesPlaylist(i);
                                    if (null == cancionesPlaylist) {
                                        System.err.println("\nError: No ha sido posible obtener el listado de canciones\n");
                                        return;
                                    }
                                    for (String s : cancionesPlaylist) {
                                        System.out.printf("%s%n", s);
                                    }
                                    System.out.printf("%nIntroduce la canción a eliminar: ");
                                    String cancionPlaylist = sc.nextLine();
                                    int j = c.busquedaCancionPlaylist(cancionPlaylist);
                                    if (-1 == j) {
                                        System.out.printf("%nNo ha introducido una cancion de la playlist%n");
                                    } else {
                                        c.borrarCancionPlaylist(i, j);
                                        System.out.printf("%nSe ha eliminado correctamente la canción de la playlist %s", tituloPlaylist);
                                    }
                                }
                                break;
                            case "v":
                                volver1 = true;
                                break;
                        }
                    } while (!volver1);
                    break;
                case "3":
                    String subMenu2 = "\n\nAÑADIR CANCIÓN A LA PLAYLIST"
                            + "\n1.- Buscar playList e introducir una canción nueva"
                            + "\nv.- Volver";
                    boolean volver2 = false;

                    do {
                        String option2;
                        String[] avaiableOptions2 = {"1", "v"};

                        option2 = readString(subMenu2, avaiableOptions2);

                        switch (option2) {
                            case "1":
                                System.out.printf("%nIntroduzca el nombre de una playlist: ");
                                String nombrePlaylist = sc.nextLine();
                                int pos = c.busquedaPlaylist(nombrePlaylist);
                                if (-1 == pos) {
                                    System.out.printf("%nLa playlist que has introducido no se ha podido encontrar%n");
                                } else {
                                    String[] cancionesPlaylist = c.cancionesPlaylist(pos);
                                    if (null == cancionesPlaylist) {
                                        System.err.println("\nError: No ha sido posible obtener el listado de canciones\n");
                                        return;
                                    }
                                    for (String s : cancionesPlaylist) {
                                        System.out.printf("%s%n", s);
                                    }
                                    System.out.printf("%nIntroduce la canción que quieres añadir: ");
                                    String cancionPlaylist = sc.nextLine();
                                    int j = c.busquedaCancion(cancionPlaylist);
                                    if (-1 == j) {
                                        c.añadirCancionSongs(cancionPlaylist);
                                        c.añadirCancionPlaylist(cancionPlaylist, pos, j);
                                        System.out.printf("%n%nSe ha añadido correctamente la canción de la playlist %s", nombrePlaylist);
                                    } else {
                                        System.out.printf("%nHa introducido una cancion existente%n");
                                    }
                                }
                                break;
                            case "v":
                                volver2 = true;
                                break;
                        }
                    } while (!volver2);
                    break;
                case "v":
                    volver = true;
                    break;
            }
        } while (!volver);

    }

    private void canciones() {
        String menuCanciones = "\n"
                + "============== CANCIONES =============="
                + "\n1.- Listado General"
                + "\nv.- Volver al menu principal"
                + "\n======================================="
                + "\nOpciones ->";

        boolean volver = false;

        do {
            String option;
            String[] avaiableOptions = {"1", "v"};

            option = readString(menuCanciones, avaiableOptions);

            switch (option) {
                case "1":
                    String[] canciones = c.cancionesColumns();
                    if (null == canciones) {
                        System.out.printf("%n%nError: No se han podido obtener las canciones%n%n");
                        return;
                    }
                    for (String c : canciones) {
                        System.out.printf("%s%n", c);
                    }
                    break;
                case "v":
                    volver = true;
                    break;
            }
        } while (!volver);
    }

} // End of class View
