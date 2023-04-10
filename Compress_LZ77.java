package compress_LZ7;

public class lz77 {
	public static void main(String[] args) {
		System.out.println("first test case");
		String text1="ababcabcd";
		int sw_size1 =10; //search window size
		int la_size1 =10; //look ahead window
		compression(text1,sw_size1,la_size1);
		
		
//		System.out.println("second test case");
//		String text2="ABAABABAABB";
//		int sw_size2 =2;
//		int la_size2 =1;
//		compression(text2,sw_size2,la_size2);
//		
//		
//		System.out.println("third test case");
//		String text3="AACAACABCABAA";
//		int sw_size3 =text3.length();
//		int la_size3 =text3.length();
//		compression(text3,sw_size3,la_size3);
//		
//		System.out.println("fourth test case");
//		String text4="ABAABABAABB";
//		int sw_size4 =text4.length();
//		int la_size4 =text4.length();
//		compression(text4,sw_size4,la_size4);
		
	}
	public static void compression(String t,int swsize,int lasize)
	{
		int[] position=new int [t.length()];//position array to save all positions to use it when print
		int[] length=new int [t.length()];
		char[] nextsymbol=new char[t.length()];
		char[] searchwindow=new char [t.length()];
		int swp=0;//to loop through search window
		int counter=0;//point to position,length,next char arrays current index
		int len=0;//length of the encoded characters
		for(int i=0;i<t.length();)
		{
			if(swp==0)//first char in string
			{
				searchwindow[swp]=t.charAt(i);
				swp++;
				position[counter]=0;
				length[counter]=0;
				nextsymbol[counter]=t.charAt(i);
				counter++;
				i++;
				
			}
			else
			{
				int temp;//last position you can search in due to swsize
				if(swsize >= swp)//to prevent negative indexs
				{
					temp=0;
				}
				else
				{
					temp=i-swsize;
				}
				 len=0;
				int c1=0;//check swsize constraint
			    int c2=0;//check lookahead constraint
				boolean b=false; //to check if char is found in searchwindow or not
				for(int j=i-1;j>=temp;j--)
				{
					if(c1<swsize)
					{
						c1++;
						if(searchwindow[j]==t.charAt(i))
						{
							len++;
							b=true;			
							position[counter]=i-j;//i-j is the no of steps we move backward to find char
							searchwindow[swp] = t.charAt(i);
							swp++;
						    c2++;
						    if(i==(t.length()-1))//last char in string
							{
								nextsymbol[counter]='/';
								length[counter]=len;
								counter++;
								i++;
								break;
							}
							while(searchwindow[j+1]==t.charAt(i+1)&&(j!=swp-1)&&(c2<lasize) &&(i!=t.length()-1))
							{
								c2++;
								searchwindow[swp]=t.charAt(i+1);
								swp++;
								len++;
								i++;
								j++;
							}
							
	
								i++;
								nextsymbol[counter]=t.charAt(i);
								
								searchwindow[swp]= t.charAt(i);
								i++;
								swp++;

								
								length[counter]=len;
								counter++;
								break;
							
							
						}
						
					}
				}
					
				if(b==false)//char not found
				{
					searchwindow[swp]=t.charAt(i);
					swp++;
					position[counter]=0;
					length[counter]=0;
					nextsymbol[counter]=t.charAt(i);
					counter++;
				    i++;
				}
				
				
				
			}
			
		}
		for(int m=0;m<counter;m++)
		{
			System.out.println("<"+position[m]+","+length[m]+","+nextsymbol[m]+">");
			
			
		}
	}

}
