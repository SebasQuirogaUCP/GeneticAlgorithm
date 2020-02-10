package geneticalgoritm;
public class FuncionFitness {
private int respuesta=0;
int temp=0;
private int TAMANO_PROGENITOR;
private int FUNCION_FITNESS;
int NUEVO_PADRE[] = new int[TAMANO_PROGENITOR];

    public void FuncionFitness(){
    };
    public void setPadre(int PADRE[] ,  int TAMANO_PROGENITOR){
        this.TAMANO_PROGENITOR=TAMANO_PROGENITOR;
        NUEVO_PADRE=PADRE;

    };
    
    public void setFuncionFitness(int FUNCION_FITNESS){
        this.FUNCION_FITNESS=FUNCION_FITNESS;
    };
    
    public int[] getNuevoPadre(){
    return NUEVO_PADRE;
    };
    
    public int evaluarFuncionFitness(int PADRE[] , int TAMANO_PROGENITOR){
        this.TAMANO_PROGENITOR=TAMANO_PROGENITOR;
        int NUEVO_PADRE[] = new int[TAMANO_PROGENITOR];
        NUEVO_PADRE=PADRE;
        
        for (int i = 0; i < TAMANO_PROGENITOR; i++) {
            temp = FUNCION_FITNESS-NUEVO_PADRE[i];
            System.out.println("EVALUANDO " + temp);
            
            if(temp==0){
                System.out.println("\n");
                System.out.println("SOLUCION: "+NUEVO_PADRE[i]);
                return 1;
            }
            
        }
        
    return respuesta;
    }
    
}
