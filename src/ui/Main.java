package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	private BufferedReader br;
	private BufferedWriter bw;
	private Stack<Integer> t1;
	private Stack<Integer> t2;
	private Stack<Integer> t3;
	private ArrayList<Integer> numProblems;

	public Main() {
		t1=new Stack<>();
		t2=new Stack<>();
		t3=new Stack<>();
		numProblems= new ArrayList<>();
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
	}


	public static void main(String[] args) {
		Main ui=new Main();
		int c=0;
		try {
			int m=Integer.parseInt(ui.br.readLine());
			ui.towerProblem(m, c);
			while(m!=0) {
				int temp=ui.numProblems.get(0);
				while(temp!=0) {
					ui.t1.add(temp);
					temp--;
				}
				ui.hanoiTower(ui.numProblems.get(0), ui.t1, ui.t2, ui.t3);
				ui.numProblems.remove(0);
				m--;
			}
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void towerProblem(int m,int c) throws IOException {
		if(c!=m) {
			numProblems.add(Integer.parseInt(br.readLine()));
			c++;
			towerProblem(m, c);
		}
	}

	
	public void hanoiTower(int n, Stack<Integer> t1,Stack<Integer> t2,Stack<Integer> t3) {
		if(n==1) {
			t3.add(t1.pop());
		}else {
			hanoiTower(n-1, t1, t3,t2);
			
		}
	}
	
	
	public Stack<Integer> getT1() {
		return t1;
	}

	public void setT1(Stack<Integer> t1) {
		this.t1 = t1;
	}

	public Stack<Integer> getT2() {
		return t2;
	}

	public void setT2(Stack<Integer> t2) {
		this.t2 = t2;
	}

	public Stack<Integer> getT3() {
		return t3;
	}

	public void setT3(Stack<Integer> t3) {
		this.t3 = t3;
	}
}
