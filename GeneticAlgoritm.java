package geneticalgoritm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;


public class GeneticAlgoritm {
    
 
 
    public static void main(String[] args) {
    Scanner tx = new Scanner(System.in);
    VerificacionProgenitor verificacionProgenitorPADRE = new VerificacionProgenitor();
    VerificacionProgenitor verificacionProgenitorMADRE = new VerificacionProgenitor();
    FuncionFitness funcionFitness = new FuncionFitness();
    
    //ArrayList<Integer> POBLACION_INICIAL = new ArrayList<Integer>();
    int TAMANO_PROGENITOR;
    int temp1=1, rand;
    int temp2;
        //JOptionPane.showMessageDialog(null, "El presente codigo optimaza la funcion f(x)=10 encontrando los resultados mas cercanos de función", "Algoritmos Geneticos",JOptionPane.INFORMATION_MESSAGE);
        
        
        System.out.println("Cuantos genes en la POBLACION");
        int TAMANO_POBLACION=tx.nextInt();
        int POBLACION_INICIAL[] = new int[TAMANO_POBLACION];
        System.out.println("Velocidad de Evolucion: ");
        int rate=tx.nextInt();
        System.out.println("FUNCION FITNESS: ");
        int FUNCION_FITNESS=tx.nextInt();
        funcionFitness.setFuncionFitness(FUNCION_FITNESS);
        
        for (int i = 0; i < TAMANO_POBLACION; i++) {
            
        //INGRESANDO POBLACION INICIAL
        System.out.println("Ingrese POBLACION INICIAL");
        POBLACION_INICIAL[i]=tx.nextInt();
        
        }
        
        
        /*
        do{
        //INGRESANDO POBLACION INICIAL
        System.out.println("Ingrese POBLACION INICIAL");
        POBLACION_INICIAL.add(tx.nextInt());
        
        System.out.println("1. Para continuar 0. Terminar con POBLACION INICIAL");
        temp1=tx.nextInt();
        
        }while(temp1==1);*/
        
        System.out.println("Mostrando POBLACION_INICIAL");
        
        
        /*//ITERADOR de tipo entero PARA RECORRER EL ARRAYLIST
        Iterator<Integer> iterador = POBLACION_INICIAL.iterator();
        while(iterador.hasNext()){
            int elemento = iterador.next();
            System.out.print(elemento+" ");
        }*/
        
        for (int i = 0; i <TAMANO_POBLACION ; i++) {
            
            System.out.print(POBLACION_INICIAL[i]+" ");
            
        }
        System.out.println("\n");
        
        //GENERANDO EL PADRE Y LA MADRE
        System.out.println("Creando PADRE y MADRE de forma ALEATORIA");
        
        //DIVIDIMOS LA POBLACION INICIAL EN DOS CROMOSOMAS: PADRE Y MADRE por seleccion 
        //que luego mutaremos 
        TAMANO_PROGENITOR=(TAMANO_POBLACION)/2;
        int PADRE[] = new int[TAMANO_PROGENITOR];
        int MADRE[] = new int[TAMANO_PROGENITOR];
        
        
        
        //**************************************
        //CROMOSOMA PADRE
        //**************************************
        
        for (int i = 0; i < TAMANO_PROGENITOR ; i++) {
            
            rand=(int)(Math.random()*TAMANO_PROGENITOR);
            System.out.println("Numero de GEN seleccionado "+rand);
            //System.out.println(rand);
            PADRE[i]=POBLACION_INICIAL[i];
            
        }
        PADRE=verificacionProgenitorPADRE.evaluarProgenitor(PADRE, TAMANO_PROGENITOR, POBLACION_INICIAL, TAMANO_POBLACION);
        
        
        
        //MOSTRANDO CROMOSOMA PADRE
        System.out.print("PROGENITOR PADRE: ");
        for (int i = 0; i < TAMANO_PROGENITOR; i++) {
                System.out.print(PADRE[i]+" ");
        }
        /*System.out.println("********************");
        System.out.println(POBLACION_INICIAL.get(0));*/
        System.out.println("\n");
        
        //**************************************
        //CROMOSOMA MADRE
        //*************************************
        for (int i = 0; i < TAMANO_PROGENITOR; i++) {
            for (int j = 0; j < TAMANO_PROGENITOR-1; j++) {
                if(i!=j){
                    do{
                       rand=(int)(Math.random()*TAMANO_POBLACION);
                       MADRE[i]=POBLACION_INICIAL[rand];
                       System.out.println("Seleccionando GENES DE POBLACION INICIAL PARA MADRE: "+MADRE[i]);
                       
                    }while(MADRE[i]==PADRE[j]);
                
                }
                
                
            }
        }
        
        /*for (int i = 0; i < TAMANO_PROGENITOR; i++) {
            for (int j = 0; j < TAMANO_PROGENITOR-1; j++) {
                    rand=(int)(Math.random()*TAMANO_PROGENITOR);
                    MADRE[i]=POBLACION_INICIAL[rand];
            }
        }*/
        
        System.out.println("\n");
        //MADRE=verificacionProgenitorMADRE.evaluarProgenitor(MADRE, TAMANO_PROGENITOR, POBLACION_INICIAL, TAMANO_POBLACION);
        
         //MOSTRANDO CROMOSOMA MADRE
        System.out.print("PROGENITOR MADRE: ");
        for (int i = 0; i < TAMANO_PROGENITOR; i++) {
                System.out.print(MADRE[i]+" ");
        }
        System.out.println("\n");
        
        
        /**************************/
        /***** CRUCE **********
        ***********************/
        System.out.println("************************************************************************");
        System.out.println("*********** EMPEZANDO PROCESO DE CRUCE Y MUTACION DE GEN PADRE CON GEN MADRE*******");
        System.out.println("************************************************************************\n");
        
            int NUEVO_PADRE[] = new int[TAMANO_PROGENITOR];
            int nuevopadre[] = new int[TAMANO_PROGENITOR];
            int contador=1;
            funcionFitness.setPadre(PADRE, TAMANO_PROGENITOR);
        do{
            
            for (int i = 0; i < TAMANO_PROGENITOR-1; i++) {
                
                    nuevopadre=funcionFitness.getNuevoPadre();
                    NUEVO_PADRE[i]=nuevopadre[(int)(Math.random()*TAMANO_PROGENITOR)]+rate; 
                    System.out.print("CRUZANDO DESDE PADRE: "+NUEVO_PADRE[i]+" ");
                    NUEVO_PADRE[i+1]=MADRE[(int)(Math.random()*TAMANO_PROGENITOR)] +rate;
                    System.out.print("CRUZANDO DESDE MADRE: "+NUEVO_PADRE[i+1]+" ");
                    
                    
                    
                        System.out.print("\n***** NUEVO PADRE: **** \n");
                        for (int j = 0; j < TAMANO_PROGENITOR; j++) {
                            
                            System.out.print(NUEVO_PADRE[j]+" ");
                                                                    }
                        
                    funcionFitness.setPadre(NUEVO_PADRE, TAMANO_PROGENITOR);    
                    System.out.println("");
            }
            
            System.out.println("");
            System.out.println("GENERACION: "+contador);
            contador++;
            temp2=funcionFitness.evaluarFuncionFitness(NUEVO_PADRE, TAMANO_PROGENITOR);
            
        }while( temp2 == 0 );
        
        System.out.print("GEN SELECCIONADO! ");
        
        for (int i = 0; i < TAMANO_PROGENITOR; i++) {
            
            System.out.print(NUEVO_PADRE[i] + " ");
                    
        }
        System.out.println("\n");
    }
    
    
    
}
