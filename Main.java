import java.util.Scanner;

public class Main {

	int target , segment ;
	boolean happened ;
	int[] songs ;
	boolean[] v ;
	int[] selected ;
	
	public static void main(String[] args) {
		new Main().start();

	}

	private void start() {
		Scanner s = new Scanner(System.in);
		int n ;
		
		while(s.hasNext()){
			target = s.nextInt();
			n = s.nextInt();
			songs = new int[n];
			v = new boolean[n];
			int sum = 0 ;
			for(int i=0 ; i<n ; i++){
				songs[i] = s.nextInt();
				sum += songs[i];
			}
			
			if(sum<=target){
				for(int i=0 ; i<songs.length ; i++){
					System.out.print(songs[i]+" ");
				}
				System.out.println("sum:"+sum);
			}
			
			else{
				happened = false ;
				while(!happened){
					for(int j=n-1 ; j>=0 ; j--){
						selected = new int[j];
						segment = j ;
						cd(0,0);
						if(happened)
							break;
					}
					if(happened)
						break;
					target--;
				}
				for(int i=0 ; i<selected.length ; i++){
					System.out.print(selected[i]+" ");
				}
				System.out.println("sum:"+target);
			}
			
			
		}
	}

	private void cd(int index ,int last) {
		
		if(index==segment){
			int sum = 0;
			for(int i=0 ; i<selected.length ; i++){
				sum+=selected[i] ;
			}
			if(sum == target)
				happened = true ;
			
			return ;
		}
		
		for(int i=last ; i<songs.length ; i++){
			if(!v[i]){
				selected[index] = songs[i];
				v[i] = true ;
				cd(index+1,i+1);
				if(happened)
					return;
				v[i] = false ;
			}
		}
	}

}
