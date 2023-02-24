import java.util.*;
import java.io.*;

class Solution_Battle_병사관리_UserSolution
{
	class Soldier {
		int mID, mScore;

		public Soldier(int mID, int mScore) {
			this.mID = mID;
			this.mScore = mScore;
		}
	}
	
	ArrayList<Soldier> soldiers[];
	
	public void init()
	{
		soldiers = new ArrayList[6];
		for(int i = 1; i <= 5; i++) {
			soldiers[i] = new ArrayList<>();
		}
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		if(soldiers[mTeam].size() == 0) {
			soldiers[mTeam].add(new Soldier(mID, mScore));
			return;
		}
		int left = 0, right = soldiers[mTeam].size()-1;
		int middle = 0;
		
		while(left <= right) {
			middle = (left + right)/2;
			if(soldiers[mTeam].get(middle).mID > mID) {
				left = middle+1;
				continue;
			}
			right = middle -1;
		}
		if(middle > right) {
			soldiers[mTeam].add(middle, new Soldier(mID, mScore));
		}
		else {
			soldiers[mTeam].add(middle+1, new Soldier(mID, mScore));
		}
	}
	
	public void fire(int mID)
	{
		
		for(int i = 1; i <= 5; i++) {
			int left = 0, right = soldiers[i].size()-1;
			int middle = 0;
			while(left <= right) {
				middle = (left + right)/2;
				if(soldiers[i].get(middle).mID == mID) {
					soldiers[i].remove(middle);
					return;
				}
				else if(soldiers[i].get(middle).mID > mID) {
					left = middle+1;
					continue;
				}
				right = middle -1;
			}
		}
	}

	public void updateSoldier(int mID, int mScore)
	{
		for(int i = 1; i <= 5; i++) {
			int left = 0, right = soldiers[i].size()-1;
			int middle = 0;
			while(left <= right) {
				middle = (left + right)/2;
				if(soldiers[i].get(middle).mID == mID) {
					soldiers[i].get(middle).mScore = mScore;
					return;
				}
				else if(soldiers[i].get(middle).mID > mID) {
					left = middle+1;
					continue;
				}
				right = middle -1;
			}
		}
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		int score;
		for(Soldier tmp : soldiers[mTeam]) {
			score = tmp.mScore + mChangeScore;
			if(score>5) {
				tmp.mScore = 5;
			}
			else if(score<1) {
				tmp.mScore = 1;
			}
			else {
				tmp.mScore = score;
			}
		}
	}
	
	public int bestSoldier(int mTeam)
	{
		int score = Integer.MIN_VALUE;
		int id = Integer.MIN_VALUE;
		for(Soldier tmp : soldiers[mTeam]) {
			if(score < tmp.mScore) {
				score = tmp.mScore;
				id = tmp.mID;
			}
			else if(score == tmp.mScore) {
				if(id < tmp.mID) {
					score = tmp.mScore;
					id = tmp.mID;
				}
			}
		}
		return id;
	}
}