package Receta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Usuario[] usuarios = new Usuario[10];
        Receta[] recetas = new Receta[50];

        usuarios[0] = new Usuario("abel", "abel@mail.com");


        Receta r = new Receta("Tarta de manzana", usuarios[0], 45, Dificultad.MEDIA, Categoria.POSTRE);
        r.agregarIngrediente(new Ingrediente("Manzana", "2 unidades"));
        r.agregarIngrediente(new Ingrediente("Harina", "200 gramos"));
        r.agregarPaso(new Paso(1, "Pelar las manzanas"));
        r.agregarPaso(new Paso(2, "Mezclar con harina"));

        recetas[0] = r;

        usuarios[0].marcarFavorita(r);

        r.valorar(5);
        r.valorar(4);

        System.out.println("valoración media: " + r.mediaValoracion());

        System.out.print("buscar por categoría (0=POSTRE 1=PASTA 2=CARNE 3=VEGANA): ");
        int cat = sc.nextInt();
        Categoria buscada = Categoria.values()[cat];

        System.out.println("recetas en categoría " + buscada + ":");
        for (Receta rec : recetas) {
            if (rec != null && rec.getCategoria() == buscada) {
                System.out.println(rec.getNombre());
            }
        }

        System.out.print("buscar por dificultad (0=FACIL 1=MEDIA 2=DIFICIL): ");
        int dif = sc.nextInt();
        Dificultad nivel = Dificultad.values()[dif];

        System.out.println("recetas con dificultad " + nivel + ":");
        for (Receta rec : recetas) {
            if (rec != null && rec.getDificultad() == nivel) {
                System.out.println(rec.getNombre());
            }
        }

        System.out.print("buscar por ingrediente: ");
        sc.nextLine();
        String ing = sc.nextLine();

        System.out.println("recetas con ingrediente " + ing + ":");
        for (Receta rec : recetas) {
            if (rec != null) {
                for (Ingrediente i : rec.getIngredientes()) {
                    if (i != null && i.getNombre().equalsIgnoreCase(ing)) {
                        System.out.println(rec.getNombre());
                        break;
                    }
                }
            }
        }
    }
}