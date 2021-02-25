package com.study24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ó���� �迭�� ũ�⸦ �־�����.
//1�� ����� ���� -> ���� ���κ����� �Ÿ��� ��Ÿ��
//2�� ����� ���� ->���� ���κ����� �Ÿ��� ��Ÿ��
//3�� ����� ���� -> ���� ���κ����� �Ÿ��� ��Ÿ��
//4�� ����� ���� -> ���� ���κ����� �Ÿ��� ��Ÿ��
//�������� �Ÿ��� ��������� �Ÿ��� x,y�� �̿��ؼ� ���� ���� ���Ѵ�.
class shop{
	int x, y;

	public shop(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
public class backjoon_2564_���� {
	static int Ddir;  
	static int Ddis;
	static int W,H;
	static int dx,dy;
	static shop[] shop;
	static int sum=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W =Integer.parseInt(st.nextToken());
		H =Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		shop = new shop[N];
		int x=0,y=0;
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			if(dir==1) 
				{x =0; y=dis;}
			if(dir==2)
				{x =H; y=dis;}
			if(dir==3)
				{x =dis; y=0;}
			if(dir==4)
				{x =dis; y=W;}
			
			shop[i] = new shop(x,y);
			
			}
		st = new StringTokenizer(br.readLine());
		Ddir = Integer.parseInt(st.nextToken());
		Ddis = Integer.parseInt(st.nextToken());
		if(Ddir==1) 
			{dx =0; dy=Ddis;}
		if(Ddir==2)
			{dx =H; dy=Ddis;}
		if(Ddir==3)
			{dx =Ddis; dy=0;}
		if(Ddir==4)
			{dx =Ddis; dy=W;}
		
		
		System.out.println(dis());
		}
	public static int dis() {
		int Sum=0;
		for (int i = 0; i < shop.length; i++) {
			int Sx=shop[i].x;
			int Sy=shop[i].y;
			int max1=0;
			int max2=0;
			//���ֺ��� ���(�� ��)
			if(Math.abs(Sx-dx)==H) {
				//System.out.println("Sx" + Sx + " " + "dx "+ dx);
				max1=Sy+dy+H;
				//System.out.println("sy , dy , ");
				max2=W-Sy+W-dy+H;
				Sum=Math.min(max1,max2);
				//System.out.println("1 "+Sum);
				continue;
			}
			//���ֺ��� ���(�� ��)
			if(Math.abs(dy-Sy)==W) {
				//System.out.println("Sx" + Sx + " " + "dx "+ dx);

				max1=Sx+dx+W;
				max2=H-Sx+H-dx+W;
				//System.out.println(max1);
				//System.out.println(max2);
				Sum+=Math.min(max1,max2);
				//System.out.println("2 "+Sum);
				continue;
			}
			 Sum += Math.abs(dy - Sy) + Math.abs(dx - Sx);
			 //System.out.println("3 "+Sum);

		}
		return Sum;
	}
}

