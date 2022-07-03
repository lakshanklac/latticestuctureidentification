/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package latticestructureidentification;
/**
 *
 * @author K.L.A.C. LAKSHAN
 */
public class latticemath {
    
    final double AVOGADRO = 6.023e-1; //avagadro number is written with power of -1 because lattice constant give more -24 power
    
        //get the input from the j textfields and save in an array
        float[] input=new float[8];
        
        //method to convert theta to sin square theta
        public float[] sinsqr(float[] input)
        {
            float[] theta=new float[8];
            for(int i=0;i<8;i++)
            {
                theta[i]=input[i]/2;
            }
            
            float[] sinsq=new float[8];
            
            for(int i=0;i<8;i++)
            {
               sinsq[i]=(float) Math.pow(Math.sin(Math.toRadians(theta[i])),2);
               //sinsqr[i]=(float) Math.sin(Math.toRadians(theta[i]));
            }
            return sinsq;
        }
        
        //method to divide each input and get the devisible value
        //for SIMPLE CUBE structure
        public int[] calsc(float[] sinsq)
        {
            //new array to store simplified sin values
            int[] sc=new int[8];
            
            for(int i=0;i<8;i++)
            {
                sc[i]=(int)Math.round(sinsq[i]/sinsq[0]);
            }
            
            //to check whether the 7th entry is seven and if so multiply everything by 2
            if(sc[6]==7)
            {
                for(int i=0;i<8;i++)
                {
                    sc[i]=sc[i]*2;
                }
            }
            return sc;  
        }
        
        //for bcc
        public int[] calbcc(float[] sinsq)
        {
            //new array to store simplified sin values
            int[] bcc=new int[8];
           
            for(int i=0;i<8;i++)
            {
                bcc[i]=(int)Math.round(sinsq[i]*2/sinsq[0]);
            }
            return bcc; 
        }
        
        //for fcc
        public int[] calfcc(float[] sinsq)
        {
            //new array to store simplified sin values
            int[] fcc=new int[8];
           
            for(int i=0;i<8;i++)
            {
                fcc[i]=(int)Math.round(sinsq[i]*3/sinsq[0]);
            }
            return fcc;
        }
        
        //method to check first few rounded off values to check the lattice type
        public int check(int[] sc,int[] bcc,int[] fcc)
        {
            int lattice=0;
            if(sc[0]==1&&sc[1]==2&&sc[2]==3)
            {
                lattice=1;
            }
            else if(bcc[0]==2&&bcc[1]==4&&bcc[2]==6)
            {
                lattice=2;
            }
            else if(fcc[0]==3&&fcc[1]==4&&fcc[2]==8)
            {
                lattice=3;
            }
            return lattice;
        }
        
        //method to print the lattice structure type
        public static String latticestr(int lattice)
        {
            String lts="Could not find";
            if(lattice==1)
            {
                lts="SIMPLE CUBIC";
            }
            if(lattice==2)
            {
                lts="BODY CENTERED CUBIC";
            }
            if(lattice==3)
            {
                lts="FACE CENTERED CUBIC";
            }
            return lts;
        }
        
        //method to find lattice constant
        public float latticeconst(int lattice,float[] sinsq,float lambda)
        {
            float a = 0;
            if(lattice==1)
            {
                a=(float)((lambda)/(2*Math.sqrt(sinsq[0])));
            }
            if(lattice==2)
            {
               a=(float)(((lambda*Math.sqrt(2))/(2*Math.sqrt(sinsq[0]))));
            }
            if(lattice==3)
            {
                a=(float)(((lambda*Math.sqrt(3))/(2*Math.sqrt(sinsq[0]))));
            }
            return a;
        }
        
        //method to calculate the density of the structure
        public float density(int lattice,float molar,float a)
        {
           float rho = 0;
            if(lattice==1)
            {
              rho=molar/(float)(Math.pow(a,3)*AVOGADRO);
            }
            if(lattice==2)
            {
               rho=(2*molar)/(float)(Math.pow(a,3)*AVOGADRO);
            }
            if(lattice==3)
            {
               rho=(4*molar)/(float)(Math.pow(a,3)*AVOGADRO); 
            }
            return rho; 
        }
        
        //method to calculate the atomic radius
        public float radius(int lattice,float a)
        {
            float rad=0;
            
            if(lattice==1)
            {
              rad=a/2;
            }
            if(lattice==2)
            {
               rad=(float)Math.sqrt(3)*a/4;
            }
            if(lattice==3)
            {
                rad=(float)Math.sqrt(2)*a/4;
            }
            return rad;
        }
        
        //method to print the number which sin values were divided
        public float num(int lattice,float[] sinsq)
        {
            float num=0;
            
            if(lattice==1)
            {
              num=sinsq[0];
            }
            if(lattice==2)
            {
               num=sinsq[0]/2;
            }
            if(lattice==3)
            {
                num=sinsq[0]/3;
            }
            return num;
        }
}
