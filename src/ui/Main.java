package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	private BufferedReader br;
	PrintWriter pw;
	private Stack<Integer> t1;
	private Stack<Integer> t2;
	private Stack<Integer> t3;
	private ArrayList<Integer> numProblems;

	public Main() throws FileNotFoundException {
		br = new BufferedReader(new FileReader("data/input.csv"));
		t1=new Stack<>();
		t2=new Stack<>();
		t3=new Stack<>();
		numProblems= new ArrayList<>();
		pw= new PrintWriter("data/output.csv");
	}

	public static void main(String[] args) {
	
		
		try {
			Main ui= new Main();
			ui.importData();
		} catch (NumberFormatException | IOException e) {
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

	public void hanoiTower(int n, Stack<Integer> t1,Stack<Integer> t2,Stack<Integer> t3) throws IOException {
		if(n==1) {
			t3.add(t1.pop());
			pw.println(this.t1.size()+" "+this.t2.size()+" "+this.t3.size());
		}else {
			hanoiTower(n-1, t1, t3,t2);
			t3.add(t1.pop());
			pw.println(this.t1.size()+" "+this.t2.size()+" "+this.t3.size());
			hanoiTower(n-1, t2,t1,t3);
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
	
	public void importData() throws IOException {
	int m=Integer.parseInt(br.readLine());
	int c=0;
	towerProblem(m, c);
	while(m!=0) {
		int temp=numProblems.get(0);
		while(temp!=0) {
			t1.add(temp);
			temp--;
		}
		pw.println(t1.size()+" "+t2.size()+" "+t3.size());
		hanoiTower(numProblems.get(0), t1, t2, t3);
		numProblems.remove(0);
		m--;
		t1.clear();
		t2.clear();
		t3.clear();
		pw.println();
	}
	br.close();
	pw.close();
	}

}
