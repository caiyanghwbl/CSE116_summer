package lab08;

public class try1 {
public int[] getResult(int[] a1,int[] a2){
  //取最大的长度作为返回结果的长度，此时未考虑是否有进位
  int length=a1.length>a2.length?a1.length:a2.length;
  //新建未考虑进位的数组结果
  int[] tmp_res =new int[length];
  int i=0;
  //循环相加得到res的按照最短数组相加的结果
  while(i<a1.length&&i<a2.length){
   i++;
   tmp_res[length-i]=a1[a1.length-i]+a2[a2.length-i];
  }
  //操作完成后，需将长数组的值赋给res
  //a1的长度说明a1比a2长度小，res需要获取a2的前几位
  if(a1.length<a2.length){
   while(length-i>0){
    tmp_res[length-i-1]=a2[a2.length-i-1];
    i++;
   }
  }else if(a1.length>a2.length){
   //说明a2比a1长度小，res需要获取a1的前几位
   while(length-i>0){
    tmp_res[length-i-1]=a1[a1.length-i-1];
    i++;
   }
  }  //考虑进位问题，如果某一元素大于10，则本身减10，前一元素加1，如果第一个元素大于10，特殊处理。
  //需处理相加之和大于10的情况
  for(int k=tmp_res.length-1;k>0;k--){
   if(tmp_res[k]>=10){
    tmp_res[k-1]=tmp_res[k-1]+1;
    tmp_res[k]=tmp_res[k]-10;
   }
  }
  int[] res=new int[length+1];
  //首位情况特殊处理
  if(tmp_res[0]>=10){
   res[0]=1;
   res[1]=tmp_res[0]-10;
   for(int m=1;m<tmp_res.length;m++){
    res[m+1]=tmp_res[m];
   }else{     res=tmp_res;   }
  }
  return res;
 }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddUtil addUtil = new AddUtil();
		int[] a1 = { 9, 2, 3, 8, 5 };
		int[] a2 = { 1, 9, 2, 3, 9 };
		for (int j : addUtil.getResult(a1, a2)) {
			System.out.print(j + ",");
		}
	}
}