package booksoft;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Julio
 */

public class BookSoft {
    
    private ArrayList<libro> registro = new ArrayList<libro>();
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> prestados = new ArrayList<String>();
    private ArrayList<persona> prestamistas = new ArrayList<persona>();
    private Scanner teclado=new Scanner(System.in);
    
    public void iniciar()
    {
        ArrayList<libro> reg_libros = new ArrayList<libro>();  
      
    }
    
    public void menu1()
    {
        System.out.println("REGISTRO BIBLIOTECA MUNICIPAL");
        System.out.println("---------------------------------");
        System.out.println("(1) GESTION DE INFORMACION");
        System.out.println("(2) GESTION DE PRESTAMOS");
        System.out.println("(3) SALIR");
                
    }
    
    public void menu2()
    {
        System.out.println("GESTION DE INFORMACION");
        System.out.println("---------------------------------");
        System.out.println("(1) Ingresar Libro");
        System.out.println("(2) Actualizar Libro");
        System.out.println("(3) Eliminar Libro");
        System.out.println("(4) Buscar Libro");
        System.out.println("(5) Salir");
                
    }
    
    public void menu3()
    {
        System.out.println("GESTION DE PRESTAMOS");
        System.out.println("---------------------------------");
        System.out.println("(1) Prestar Libro");
        System.out.println("(2) Devolver Libro");
        System.out.println("(3) Libros Prestados");
        System.out.println("(4) Salir");
                
    }
    
    public libro parche()
    {
        libro ingresado;
        ingresado=new libro();
        
        System.out.print("Nombre: "); 
        String name=teclado.next();
        ingresado.setNombre(name);
               
        System.out.print("Autor: ");        
        ingresado.setAutor(teclado.next());
        
        System.out.print("Año de publicacion: ");        
        ingresado.setAño_publicacion(teclado.nextInt());
        
        System.out.print("Codigo: ");        
        ingresado.setCodigo(teclado.nextInt());
        
        System.out.print("Cantidad: ");        
        ingresado.setCantidad(teclado.nextInt());
        
        System.out.print("Area: ");        
        System.out.println("(1)Quimica (2)Fisica (3)Tengologia (4)Calculo (5)Programacion");        
        
        int op=teclado.nextInt();
        
        switch(op)
        {
            case 1:
                ingresado.setArea("Quimica");
                break;
            case 2:
                ingresado.setArea("Fisica");
                break;
            case 3:
                ingresado.setArea("Tegnologia");
                break;
            case 4:
                ingresado.setArea("Calculo");
                break;
            case 5:
                ingresado.setArea("Programacion");
                break;
            default:
                System.out.println("No ingresaste una Area valida");
                System.out.println("Este libro requiere Actualizar");
                ingresado.setArea("Null");
                break;
        }
        return ingresado;
    }
    
    public void ingresar()
    {
        limpiar();
        System.out.println("Ingresar Libro");
        System.out.println("---------------------------------");
        
        libro ingresado=parche();
        String name=ingresado.getNombre();
                
        registro.add(ingresado);
        names.add(name);    
    }
    
        public void ingresar2(int pos)
    {
        limpiar();
        System.out.println("Nueva informacion Libro");
        
        libro ingresado=parche();
        String name=ingresado.getNombre();
                
        registro.add(pos,ingresado);
        names.add(pos,name);    
    }
    
    
    public void actualizar()
    {
        limpiar();
        System.out.println("Actualizar Libro");
        System.out.println("---------------------------------");
        System.out.print("Ingresa el nombre del libro a actualizar: ");
        
        String nom_bus=teclado.next();
        
        if(names.contains(nom_bus))
        {
            int pos=names.indexOf(nom_bus);
            registro.remove(pos);
            names.remove(pos);
            ingresar2(pos);
        }
        else{
            System.out.print("El libro no esta en registro");
        }
    
    }
    
    public void eliminar(){
        
        limpiar();
        
        System.out.println("Eliminar Libro");
        System.out.println("---------------------------------");
        System.out.print("Ingresa el nombre del libro a eliminar: ");
        
        String nom_elim=teclado.next();
        
         if(registro.isEmpty())
        {
             System.out.print("El registro es vacio");
        }
         else
          {
        
        if(names.contains(nom_elim))
        {
            int pos=names.indexOf(nom_elim);
            registro.remove(pos);
            names.remove(pos);
        }
        else{
            System.out.print("El libro no esta en registro");
        }
          }
    }
    
    public void limpiar()
    {
        for ( int i=0;i<=2;i++) 
        System.out.println(" "); 
    }
    
    public int buscar(){
        
        limpiar();
        
        System.out.println("Buscar Libro");
        System.out.println("---------------------------------");
        System.out.print("Ingresa el nombre del libro a buscar: ");
        
        String nom_busq=teclado.next();
        
        if(registro.isEmpty())
        {
             System.out.println("El registro esta vacio");
             return 0;
        }
         else
          {
            
         if(names.contains(nom_busq))
          {
            int pos=names.indexOf(nom_busq);
            
            libro librobusq=registro.get(pos);
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Nombre: "+librobusq.getNombre());
            System.out.println("Autor: "+librobusq.getAutor());
            System.out.println("Año de publicacion: "+librobusq.getAño_publicacion());
            System.out.println("Codigo: "+librobusq.getCodigo());
            System.out.println("Cantidad: "+librobusq.getCantidad());
            System.out.println("Area: "+librobusq.getArea());
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            
            return pos+1;
            
            }
                else
                {
                   System.out.println("El libro no esta en registro");
                   return 0;
                 }
         }
    }

    public void prestarlibro(){
        
        int pos=buscar();
        
        switch(pos)
        {
            case 0:
                System.out.println("El libro no encontrado");
                break;
            default:
                System.out.println("El libro encontrado");
                
                    libro libropre=registro.get(pos-1);
                    String nombre=libropre.getNombre();
                    int cantidad=libropre.getCantidad();

                    if (cantidad>0)
                    {
                    System.out.println("El libro esta en la posicion: "+pos);

                    System.out.print("Ingrese la cedula: ");

                    persona ingre;
                    ingre=new persona();        
                    String ced=teclado.next();        
                    ingre.setCedula(ced);

                    libropre.setCantidad(libropre.getCantidad()-1);

                    prestamistas.add(ingre);
                    prestados.add(nombre);

                    }

                    else{
                        System.out.println("No hay existencias");
                    }

                break;
            
        }
    }

    public static void main(String[] args) {
        
        BookSoft nuevo;
        nuevo=new BookSoft();
        Scanner teclado=new Scanner(System.in);
        
        nuevo.iniciar();
        
        int opg=0;
        while(opg==0)
        {

        nuevo.menu1();
        int op=teclado.nextInt();
        while(op==1)
        {
            nuevo.limpiar();
            nuevo.menu2();
            int op2=teclado.nextInt();
            
            switch(op2)
            {
                case 1:
                    nuevo.ingresar();
                    break;
                case 2:
                    nuevo.actualizar();
                    break;
                case 3:
                    nuevo.eliminar();
                    break;
                case 4:
                    nuevo.buscar();
                    break;
                case 5:
                    op=0;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;    
            }
            
        }
        
    while(op==2)
        {
            nuevo.limpiar();
            nuevo.menu3();
            
            int op3=teclado.nextInt();
            
            switch(op3)
            {
                case 1:
                    nuevo.prestarlibro();
                    break;
                case 2:
                    //nuevo.devolver();
                    break;
                case 3:
                    //nuevo.libros();
                    break;
                case 4:
                    op=0;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;    
            }
            
        }
    
        if(op==3)
        {
        opg=1;
         }

        
        }
    }
}
