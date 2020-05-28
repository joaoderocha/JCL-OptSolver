package implementation.user_commands;

import java.io.BufferedReader;
import java.io.FileReader;

import interfaces.kernel.JCL_facade;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import kernel.user_commands.LoadAbstract;
import kernel.utils.JcldataAccess;

public class DistanceMatrix extends LoadAbstract {
    public void load(String filePath){
        super.load(filePath);;
        try{
            Object2ObjectMap<String, Float> distances = new Object2ObjectOpenHashMap<String, Float>();
                
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String str = null;	  
                             
            float[][] matrix = null;
            int linha = 0;
            float lower=0;
            int matrixSize = 0;
            //ler o arquivo
            while ((str = in.readLine()) != null) {
                if(!str.trim().equals("EOF")){
                    String[] inputDetalhes = str.split(" ");
                    if(matrix==null){
                        matrixSize = 0;
                        for(String frag:inputDetalhes){
                            if(!frag.equals("")) matrixSize++;
                        }
                        System.out.println("dimens�o da matriz: " + matrixSize);
                        matrix = new float[matrixSize][matrixSize];
                    }
                    int coluna =0;
                    for(String frag:inputDetalhes){
                        if(!frag.equals("")) {
                            matrix[linha][coluna] = Float.parseFloat(frag);
                            coluna++;	        				 
                        }
                    }
                    
                    linha++;
                }
            }
            
            in.close();
            in=null;
            
            JCL_facade jcl = JcldataAccess.getLambari();
            
            @SuppressWarnings("unchecked")
            ObjectSet<String> vertices = (ObjectSet<String>) jcl.getValue("vertices").getCorrectResult();
            jcl.instantiateGlobalVar("numOfVertices", matrixSize);
            float lowest = Float.MAX_VALUE;
           
            //montando distancias	                  
            for (int i=0; i<matrix.length;i++){
                float menorD = Float.MAX_VALUE;
                float maiorD = Float.MIN_VALUE;
                vertices.add("$"+(i+1)+"$");
                
                for(int j=0; j<matrix.length; j++){
                    if(i!=j){
                        distances.put("$"+(i+1)+"$:$"+(j+1)+"$", matrix[i][j]);
                        if(matrix[i][j]<menorD) menorD = matrix[i][j];
                        if(matrix[i][j]>maiorD) maiorD = matrix[i][j];
                        
                    }
                }	        	 

                distances.put("$"+(i+1)+"$:$shorterD$", menorD);
                distances.put("$"+(i+1)+"$:$longerD$", maiorD);
                
                lower+=menorD;
                if(lowest>menorD)
                    lowest=menorD;	        	         	 
                
            }	         
            
            lower+=lowest; 	         
                         
            jcl.setValueUnlocking("vertices", vertices);
            
            jcl.setValueUnlocking("lower", lower);
            
            JcldataAccess.instantiateVarInJCL("distances", distances);
            
            for(String k:distances.keySet()){
                System.out.println("Key: " + k + " || value: " + distances.get(k));
            }
       }catch (Exception e){
           
       }
    }
}