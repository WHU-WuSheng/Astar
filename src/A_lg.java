import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class A_lg {
	
	public static int paycount(S s,int d)
	{
		int pay=d;
		
		if(s.x[0][0]!=1) pay++;
		if(s.x[0][1]!=2) pay++;
		if(s.x[0][2]!=3) pay++;
	    if(s.x[1][0]!=8) pay++;
		//if(s.x[1][1]!=0) pay++;
		if(s.x[1][2]!=4) pay++;
		if(s.x[2][0]!=7) pay++;
		if(s.x[2][1]!=6) pay++;
		if(s.x[2][2]!=5) pay++;
		
		return pay;
	}
	
	public static Boolean equal(int[][] x,int[][] y)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(x[i][j]!=y[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static Boolean testpre(int[][]newx,S s) {
		S test=s;
		while(test.parent!=null)
		{
			if(equal(test.parent.x,newx))
				return true;
			test=test.parent;
		}
		
		return false;
	}
	
	public static int[][] copy(int[][] s)
	{
		int[][] x=new int[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				x[i][j]=s[i][j];
			}
		}
		return x;
	}

	public static S star()
	{
		ArrayList<S> open=new ArrayList<>();
		S s0=new S();
		int[][] x= {{2,8,3},{1,6,4},{7,0,5}};//初始状态
		int[][] goal= {{1,2,3},{8,0,4},{7,6,5}};//目标状态
		s0.setx(x); 
		open.add(s0);//初始open表
		
		ArrayList<S> closed=new ArrayList<>(); //初始closed表
		
		int d=0;//初始树深度
		s0.pay=paycount(s0,d); //初始s0费用
		S n = null;
		while(open.size()!=0)//open为空退出
		{
			int min=999;
			for(int i=0;i<open.size();i++)
			{
				if(open.get(i).pay<=min)
				{
					min=open.get(i).pay;
					n=open.get(i);
				}
			} //选出代价最小的节点放入n中
			
			open.remove(n);
			closed.add(n); //将节点放入closed表中
			
			if(equal(n.x, goal))
			{
				System.out.println("成功啦");
				return n;
			}//如果是目标成功退出
			
			ArrayList<S> M=new ArrayList<>(); //第六步
			
			if(n.x[0][0]==0)
			{
				int [][]newx=copy(n.x);
				newx[0][0]=n.x[0][1];
				newx[0][1]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[0][0]=n.x[1][0];
				newx[1][0]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
			}else if(n.x[0][1]==0)
			{
				int [][]newx=copy(n.x);
				newx[0][1]=n.x[0][0];
				newx[0][0]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[0][1]=n.x[0][2];
				newx[0][2]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[0][1]=n.x[1][1];
				newx[1][1]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
			}else if(n.x[0][2]==0)
			{
				int [][]newx=copy(n.x);
				newx[0][2]=n.x[0][1];
				newx[0][1]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[0][2]=n.x[1][2];
				newx[1][2]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
			}else if(n.x[1][0]==0)
			{
				int [][]newx=copy(n.x);
				newx[1][0]=n.x[0][0];
				newx[0][0]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][0]=n.x[1][1];
				newx[1][1]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][0]=n.x[2][0];
				newx[2][0]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
			}else if(n.x[1][1]==0)
			{
				int [][]newx=copy(n.x);
				newx[1][1]=n.x[1][0];
				newx[1][0]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][1]=n.x[0][1];
				newx[0][1]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][1]=n.x[1][2];
				newx[1][2]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][1]=n.x[2][1];
				newx[2][1]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
			}else if(n.x[1][2]==0)
			{
				int [][]newx=copy(n.x);
				newx[1][2]=n.x[1][1];
				newx[1][1]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][2]=n.x[0][2];
				newx[0][2]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][2]=n.x[2][2];
				newx[2][2]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
			}else if(n.x[2][0]==0)
			{
				int [][]newx=copy(n.x);
				newx[2][0]=n.x[1][0];
				newx[1][0]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[2][0]=n.x[2][1];
				newx[2][1]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
			}else if(n.x[2][1]==0)
			{
				int [][]newx=copy(n.x);
				newx[2][1]=n.x[2][0];
				newx[2][0]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[2][1]=n.x[1][1];
				newx[1][1]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[2][1]=n.x[2][2];
				newx[2][2]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
			}else if(n.x[2][2]==0)
			{
				int [][]newx=copy(n.x);
				newx[2][2]=n.x[2][1];
				newx[2][1]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[2][2]=n.x[1][2];
				newx[1][2]=0;
				if(testpre(newx,n)==false) //如果不是n的前驱结点
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,d);
					M.add(s);
				}
			}
			//至此全部存入M中，第六步完成，开始第七步
			
			ArrayList<S> G=new ArrayList<>(); 
			for(int i=0;i<open.size();i++)
			{
				G.add(open.get(i));
			}
			for(int i=0;i<closed.size();i++)
			{
				G.add(closed.get(i));
			}
			
			for(int i=0;i<M.size();i++)
			{
				Boolean judge=false;
				for(int j=0;j<G.size();j++) 
				{
					if(equal(M.get(i).x, G.get(j).x)==true) //如果在G中没有
					{
						judge=true;
					}
				}
				if(judge==false) open.add(M.get(i));
			}
			
			d++;
		}
		return null;
	}
	
	static boolean climb_judge=true;
	public static S climb()
	{
		S s0=new S();
		int[][] x= {{2,8,3},{1,6,4},{7,0,5}};//初始状态
		int[][] goal= {{1,2,3},{8,0,4},{7,6,5}};//目标状态
		s0.setx(x); 
		
		boolean judge=true;
		S n=s0;
		while(judge)
		{
			ArrayList<S> M=new ArrayList<>();
			
			if(n.x[0][0]==0)
			{
				int [][]newx=copy(n.x);
				newx[0][0]=n.x[0][1];
				newx[0][1]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[0][0]=n.x[1][0];
				newx[1][0]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
			}else if(n.x[0][1]==0)
			{
				int [][]newx=copy(n.x);
				newx[0][1]=n.x[0][0];
				newx[0][0]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[0][1]=n.x[0][2];
				newx[0][2]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[0][1]=n.x[1][1];
				newx[1][1]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
			}else if(n.x[0][2]==0)
			{
				int [][]newx=copy(n.x);
				newx[0][2]=n.x[0][1];
				newx[0][1]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[0][2]=n.x[1][2];
				newx[1][2]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
			}else if(n.x[1][0]==0)
			{
				int [][]newx=copy(n.x);
				newx[1][0]=n.x[0][0];
				newx[0][0]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][0]=n.x[1][1];
				newx[1][1]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][0]=n.x[2][0];
				newx[2][0]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
			}else if(n.x[1][1]==0)
			{
				int [][]newx=copy(n.x);
				newx[1][1]=n.x[1][0];
				newx[1][0]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][1]=n.x[0][1];
				newx[0][1]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][1]=n.x[1][2];
				newx[1][2]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][1]=n.x[2][1];
				newx[2][1]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
			}else if(n.x[1][2]==0)
			{
				int [][]newx=copy(n.x);
				newx[1][2]=n.x[1][1];
				newx[1][1]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][2]=n.x[0][2];
				newx[0][2]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[1][2]=n.x[2][2];
				newx[2][2]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
			}else if(n.x[2][0]==0)
			{
				int [][]newx=copy(n.x);
				newx[2][0]=n.x[1][0];
				newx[1][0]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[2][0]=n.x[2][1];
				newx[2][1]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
			}else if(n.x[2][1]==0)
			{
				int [][]newx=copy(n.x);
				newx[2][1]=n.x[2][0];
				newx[2][0]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[2][1]=n.x[1][1];
				newx[1][1]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[2][1]=n.x[2][2];
				newx[2][2]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
			}else if(n.x[2][2]==0)
			{
				int [][]newx=copy(n.x);
				newx[2][2]=n.x[2][1];
				newx[2][1]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
				
				newx=copy(n.x);
				newx[2][2]=n.x[1][2];
				newx[1][2]=0;
				{
					S s=new S();
					s.parent=n;
					s.x =newx;
					s.pay=paycount(s,0);
					M.add(s);
				}
		      }
			for(int i=0;i<M.size();i++)
			{
				if(equal(M.get(i).x,goal))
				{
					return M.get(i);
				}
			} //有就返回
			
			int min=999;
			S buf=null;
			for(int i=0;i<M.size();i++)
			{
				if(M.get(i).pay<=min)
				{
					min=M.get(i).pay;
					buf=M.get(i);
				}
			} //选出最小的放到n里去
			
			if(testpre(buf.x,n))
			{
				climb_judge=false;
				return n;
			}else
			{
				n=buf;
			}
			
			
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		while(result.parent!=null)
//		{
//			System.out.println(result.x[0][0]+" "+result.x[0][1]+" "+result.x[0][2]+"\n"+
//					result.x[1][0]+" "+result.x[1][1]+" "+result.x[1][2]+"\n"+   
//					result.x[2][0]+" "+result.x[2][1]+" "+result.x[2][2]+"\n");
//			result=result.parent;
//		}
		
		JFrame box = new JFrame("A*算法和爬山法解决8数码问题");
		box.setBounds(150, 150, 950, 600);
		box.setLayout(null);
		
		box.setVisible(true);
		Font f=new Font("华文行楷",Font.BOLD,35);
		
		JButton b1=new JButton("2");
		b1.setBounds(100, 50, 100, 100);
		b1.setFont(f);
		box.add(b1);
		
		JButton b2=new JButton("8");
		b2.setBounds(250, 50, 100, 100);
		b2.setFont(f);
		box.add(b2);

		JButton b3=new JButton("3");
		b3.setBounds(400, 50, 100, 100);
		b3.setFont(f);
		box.add(b3);
		
		JButton b4=new JButton("1");
		b4.setBounds(100, 220, 100, 100);
		b4.setFont(f);
		box.add(b4);
		
		JButton b5=new JButton("6");
		b5.setBounds(250, 220, 100, 100);
		b5.setFont(f);
		box.add(b5);
		
		JButton b6=new JButton("4");
		b6.setBounds(400, 220, 100, 100); 
		b6.setFont(f);
		box.add(b6);
		
		JButton b7=new JButton("7");
		b7.setBounds(100, 400, 100, 100);  
		b7.setFont(f);
		box.add(b7);
		
		JButton b8=new JButton("0");
		b8.setBounds(250, 400, 100, 100); 
		b8.setFont(f);
		box.add(b8);
		
		JButton b9=new JButton("5");
		b9.setBounds(400, 400, 100, 100); 
		b9.setFont(f);
		box.add(b9);
		
		
		JButton b10=new JButton("A*算法归位");
		b10.setBounds(600, 50, 300, 100); 
		b10.setFont(f);
		box.add(b10);
		
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				S result=star();
				ArrayList<S> show=new ArrayList<>();
				while(result.parent!=null)
					{
						show.add(result);
						result=result.parent;
					}
				
				final Thread thread=new Thread() {
					public void run() {
						for(int i=show.size()-1;i>=0;i--)
						{
							b1.setText(String.valueOf(show.get(i).x[0][0]));
							b2.setText(String.valueOf(show.get(i).x[0][1]));
							b3.setText(String.valueOf(show.get(i).x[0][2]));
							b4.setText(String.valueOf(show.get(i).x[1][0]));
							b5.setText(String.valueOf(show.get(i).x[1][1]));
							b6.setText(String.valueOf(show.get(i).x[1][2]));
							b7.setText(String.valueOf(show.get(i).x[2][0]));
							b8.setText(String.valueOf(show.get(i).x[2][1]));
							b9.setText(String.valueOf(show.get(i).x[2][2])); 
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
				};
				thread.start();
				
				
			}
		});
		
		JButton b11=new JButton("重置");
		b11.setBounds(600, 200, 300, 100); 
		b11.setFont(f);
		box.add(b11);
		
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				b1.setText(String.valueOf(2));
				b2.setText(String.valueOf(8));
				b3.setText(String.valueOf(3));
				b4.setText(String.valueOf(1));
				b5.setText(String.valueOf(6));
				b6.setText(String.valueOf(4));
				b7.setText(String.valueOf(7));
				b8.setText(String.valueOf(0));
				b9.setText(String.valueOf(5));
				
			}
		});
		
		JButton b12=new JButton("爬山法归位");
		b12.setBounds(600, 350, 300, 100); 
		b12.setFont(f);
		box.add(b12);
		
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				S result=climb();
				if(climb_judge==false)
				{
					JOptionPane.showMessageDialog(null, "爬山法经运行无解,运行至\n"+result.x[0][0]+" "+result.x[0][1]+" "+result.x[0][2]+"\n"+
							result.x[1][0]+" "+result.x[1][1]+" "+result.x[1][2]+"\n"+   
							result.x[2][0]+" "+result.x[2][1]+" "+result.x[2][2]+"\n后进入死循环"+"详情见报告分析过程", null,
							JOptionPane.PLAIN_MESSAGE);
				}else
				{
					ArrayList<S> show=new ArrayList<>();
					while(result.parent!=null)
						{
							show.add(result);
							result=result.parent;
						}
					
					final Thread thread=new Thread() {
						public void run() {
							for(int i=show.size()-1;i>=0;i--)
							{
								b1.setText(String.valueOf(show.get(i).x[0][0]));
								b2.setText(String.valueOf(show.get(i).x[0][1]));
								b3.setText(String.valueOf(show.get(i).x[0][2]));
								b4.setText(String.valueOf(show.get(i).x[1][0]));
								b5.setText(String.valueOf(show.get(i).x[1][1]));
								b6.setText(String.valueOf(show.get(i).x[1][2]));
								b7.setText(String.valueOf(show.get(i).x[2][0]));
								b8.setText(String.valueOf(show.get(i).x[2][1]));
								b9.setText(String.valueOf(show.get(i).x[2][2])); 
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						}
					};
					thread.start();
				}
			
			}
		});


	}

}
