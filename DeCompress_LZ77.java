package decompress_LZ77;

public class DeLZ77 {

	 public static void main(String[] args) {
		
		 String str = "<0,0,s><0,1,b><0,2,k><0,0,m><0,4,z>";
		 String num="",decom="";
		 String [] nchar = new String[100] ;
		int [] pos =  new int[100];
		int [] ln= new int[100];
	
	     int len=str.length();
	     int l=0,r=1,i=0,temp=len;
	     boolean c=true;
	       while(len>=0){
	    	   while(true)
	    	   {   if(str.length()>r)
	    	   {    r++;}
	    	       len--;
	    		   if(str.substring(r-1,r).equals(",")||str.substring(r-1,r).equals(">")||str.substring(r-1,r).equals("<"))
	    			 { l++;
	    			 break;}
	    		 }
	    	   
	    	   if(str.substring(r-1,r).equals(">")) {
	    		   nchar[i]=str.substring(r-2,r-1);
	    		    // System.out.println("nchar");
	    		  // System.out.println(nchar[i]);
	    		   i++;
	    		   if((r+1)>str.length())
	    		   break;
	    		   r++;
	    		   l=r-1;
	    	   }
	    	   else 
	    		   {  num=str.substring(l,r-1);
	    	             l=r-1;

	    	   if(c)
	    		 {   
	              pos[i]=Integer.parseInt(num);
	            //System.out.println("pos= ");
	            //  System.out.println(pos[i]);
	    		     c=false;
	    		 }
	    		   
	    	   else 
	             {  
	                 ln[i] = Integer.parseInt(num);
	              // System.out.println("len= ");
	              // System.out.println(ln[i]);
	             c=true;}
	    	         }
	    }
	       decom+=nchar[0];
           for(int j=1;j<i;j++) {
           	decom+=decom.substring(pos[j],ln[j]);
           	decom+=nchar[j]; 		
           }
           System.out.println(decom);
	       
}

	}
	 
