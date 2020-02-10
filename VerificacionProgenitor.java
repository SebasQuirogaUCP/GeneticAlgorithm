package geneticalgoritm;

import static java.lang.Math.random;

public class VerificacionProgenitor {
private int TAMANO_PROGENITOR, TAMANO_POBLACION;
private int rand;
    public void VerificacionProgenitor(){
    }
    
    public int[] evaluarProgenitor(int a[], int TAMANO_PROGENITOR, int POBLACION[] , int TAMANO_POBLACION){
        TAMANO_PROGENITOR=TAMANO_PROGENITOR;
        int CROMOSOMA_EVALUAR[] = new int[TAMANO_PROGENITOR];
        int CROMOSOMA_POBLACION[] = new int[TAMANO_POBLACION];
        
        CROMOSOMA_EVALUAR = a;
        CROMOSOMA_POBLACION= POBLACION;
        
        for (int i = 0; i < TAMANO_PROGENITOR; i++) {
            
            for (int j = 0; j < TAMANO_PROGENITOR-1; j++) {
            
                if(i!=j){
                    if(CROMOSOMA_EVALUAR[i] == CROMOSOMA_EVALUAR[j]) {
                        
                        do{
                            rand=(int)(Math.random()*TAMANO_PROGENITOR);
                            CROMOSOMA_EVALUAR[i]=CROMOSOMA_POBLACION[rand];
                        }while(CROMOSOMA_EVALUAR[i] == CROMOSOMA_EVALUAR[j]  );
                    
                    }   
                }
                
            }
            
        }
    return CROMOSOMA_EVALUAR;
    }
}
