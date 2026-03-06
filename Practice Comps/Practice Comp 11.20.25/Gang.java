import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Gang {
	
	ArrayList<String> names;
	int[] health, protect, confuse, tboost;
	boolean[] done, fboost;
	boolean draw;
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("gang.dat"));
		int times = file.nextInt();
		file.nextLine();
		names = new ArrayList<String>();
		names.add("Hawkgirl");names.add("Riddler");names.add("Mr-Terrific");
		names.add("Mr-Freeze");names.add("Green-Lantern");names.add("Clayface");
		while(times-- > 0) {
			health = new int[] {150, 100, 100, 200, 250, 200};
			protect = new int[6];
			confuse = new int[6];
			tboost = new int[6];
			fboost = new boolean[6];
			done = new boolean[6];
			draw = !check();
			int rounds = file.nextInt() * 6, num = 0;
			file.nextLine();
			while(rounds-- > 0 && draw) {
				String action = file.next();
				int tar = names.indexOf(file.next());
				file.nextLine();
				action(action, tar, num);
				num = (num + 1) % 6;
				//System.out.println(Arrays.toString(health));
			}
			//System.out.println(Arrays.toString(health));
			//System.out.println(rounds);
			if(draw) 
				System.out.println("Draw");
			while(rounds-- >= 0)
				file.nextLine();
		}
	}
	
	void action(String action, int tar, int num) {
		if(done[num])return;
		if(confuse[num] > 0) {
			confuse[num] --;
			return;
		}
		if(protect[tar] == 0)
			switch(action) {
			case "Mace": health[tar] -= tboost[num] == 0? 10: 20;				break;
			case "Claws": health[tar] -= tboost[num] == 0? 8: 16;				break;
			case "Fly": confuse[tar] = 1;protect[tar] = 1;health[tar] -= 4;		break;
			case "Gun": health[tar] -= fboost[num] ? 16: 6;						break;
			case "Staff": health[tar] -= fboost[num] ? 14: 4;					break;
			case "Riddle": confuse[tar] = 2;									break;
			case "Kick": health[tar] -= tboost[num] == 0? 4: 8;					break;
			case "Orbs": health[tar] -= tboost[num] == 0? 10: 20;				break;
			case "Orb-Boost": tboost[tar] = 1;									break;
			case "Punch": health[tar] -= fboost[num]? 17: 7;					break;
			case "Freeze-Ray": health[tar] -= fboost[num]? 22: 12;				break;
			case "Freeze-Boost": fboost[tar] = true;							break;
			case "Fist": health[tar] -= tboost[num] == 0? 10: 20;				break;
			case "Bat": health[tar] -= tboost[num] == 0? 9: 18;					break;
			case "Green-Shield": protect[tar] = 2;								break;
			case "Spikeball": health[tar] -= fboost[num]? 21: 11;				break;
			case "Stab": health[tar] -= fboost[num]? 18: 8;						break;
			case "Clay-Shield": protect[tar] = 1;								break;
			}
		fboost[num] = false;
		tboost[num] = tboost[num] == 0? 0: tboost[num] - 1;
		protect[num] = protect[num] == 0? 0: protect[num] - 1;
		draw = !check();
	}
	
	boolean check() {
		if(!done[0] && health[0] <= 0) {
			System.out.println("Hawkgirl Defeated.");
			done[0] = true;
		}
		if(!done[1] && health[1] <= 0) {
			System.out.println("Riddler Defeated.");
			done[1] = true;
		}
		if(!done[2] && health[2] <= 0) {
			System.out.println("Mr-Terrific Defeated.");
			done[2] = true;
		}
		if(!done[3] && health[3] <= 0) {
			System.out.println("Mr-Freeze Defeated.");
			done[3] = true;
		}
		if(!done[4] && health[4] <= 0) {
			System.out.println("Green-Lantern Defeated.");
			done[4] = true;
		}
		if(!done[5] && health[5] <= 0) {
			System.out.println("Clayface Defeated.");
			done[5] = true;
		}
		if(done[0] && done[2] && done[4]) {
			System.out.println("Justice Loss");
			return true;
		}
		if(done[1] && done[3] && done[5]) {
			System.out.println("Justice Win");
			return true;
		}
		return false;
	}
	
	public static void main(String[]args)throws Exception{
		new Gang().run();
	}
}
