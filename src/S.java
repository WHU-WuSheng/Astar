
public class S {
	
	int [][]x=new int[3][3]; 
	
	S parent=null;
	
	int pay;
	
	public int[][] getx()
	{
		return x;
	}
	
	public void setx(int [][]y)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				x[i][j]=y[i][j];
			}
		}
	}
	
	public S getparent()
	{
		return parent;
	}
	
	public void setparent(S p)
	{
		parent=p;
	}

}
