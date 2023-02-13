package algorithm.daily.ws0210;

import java.util.LinkedList;
import java.util.Queue;

public class 마이쮸_손민우 {
	public static void main(String[] args) {
		Myzzu mz = new Myzzu(); //마이쮸dto
		Queue<Myzzu> q = new LinkedList<>();
		int count = 20;
		int person = 1;
		int who =0;// 마이쮸 받고 나온 사람.
		int totalCount = 0; //그 사람이  받은 개수
		while(count>=0) {
			mz = new Myzzu(person++, 0); //새로운 사람이 줄스기
			
			q.add(mz); //큐에 추가
			
			mz = q.poll(); //받고 나온사람.
			who = mz.getPeopleNum();// 받고 나온사람의 넘버
			totalCount = mz.getCount()+1;// 받고 나온 사람의 마이쮸 개수
			
			count = count-totalCount;//줄어든 총 마이쮸ㅠ
			
			mz = new Myzzu(who, totalCount);//받자마자 다시 줄서는 사람;;
			q.add(mz); //큐에 추가
		}
		System.out.println(mz);
	}
}


//마이쮸받는 사람dto
class Myzzu{
	int peopleNum; //사람번호
	int count;		//받은개수
	public Myzzu() {}
	public Myzzu(int peopleNum, int count) {
		this.peopleNum = peopleNum;
		this.count = count;
	}
	/**
	 * @return the peopleNum
	 */
	public int getPeopleNum() {
		return peopleNum;
	}
	/**
	 * @param peopleNum the peopleNum to set
	 */
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("20번재로 받은 사람은 ");
		builder.append(peopleNum);
		builder.append("번이며, 총 받아간 개수는 ");
		builder.append(count);
		builder.append("개 입니다.");
		return builder.toString();
	}
	
	
}