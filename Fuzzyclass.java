/* not authorized for copy  or distribute or reuse*/
/*this clas do all operation related to fuzzy  calculs 
membership grade-rules- truncate-defuzzification
and applying the  whole  Fuzzy algorithm  for tow inputs that present  density of the winning  
traffic light  and the   max of the   next  higher density  on other trffic lights !
*/
package fuzzysemafor;

/* Tia Shami*/
public class Fuzzyclass {
    //---input membership functions---
  public   float wdensity[][] = new float[][]{{0,10,20,10,20,35,20,35,45,}, {1,1,0,0,1,0,0,1,1}};//density of  cars
  
   public float density[][]  = new float[][]{{0,10,20,10,20,35,20,35,45,}, {0,1,0,0,1,0,0,1,0}};//density  another func
   //----- output membership function-------
    public float green[][]  = new float[][]{{0,40,80,40,80,120,80,120,160}, {0,1,0,0,1,0,0,1,0}};//green  time
     public float green2[][]  = new float[][]{{0,20,60,20,60,100,60,100,120}, {0,1,0,0,1,0,0,1,0}};//green2  time
public float winner ;
public float rest;
public float membershipvalues[]=new float[3];
public float mem1[]=new float[3]; //store  membership values for second input
public float mem2[]=new float[3];//store  membership values for second input
public float truncval[]=new float[3];//store truncet values
    public void Fuzzyclass() {
    
    }
  //----simple function that get  a membership grade
    public  void getmembership(float x){
        //reset the  array
        membershipvalues[0]=0;
        membershipvalues[1]=0;
        membershipvalues[2]=0;
        
        float y;
      //  start evaluating 
        //---------------------------------------------
        //------out of range --------------------------+
        if(x <= wdensity[0][0])membershipvalues[0]=0;
        
        if(x > wdensity[0][8])  membershipvalues[2]=1;
     //--------------testing segments one by one 
      if((x >= wdensity[0][0])&&( x<=wdensity[0][1]))   membershipvalues[0]=1;
     if((x >= wdensity[0][1])&&( x<=wdensity[0][2])) {
         y= 1-( (x-wdensity[0][1])/(wdensity[0][2]-wdensity[0][1]));
         membershipvalues[0]= y; }
     
     if((x > wdensity[0][3])&&( x<=wdensity[0][4]))
     {y= (x-wdensity[0][3])/(wdensity[0][4]-wdensity[0][3]);
         membershipvalues[1]=y;
             }
     if((x >= wdensity[0][4])&&( x<=wdensity[0][5])){
          y= 1-( (x-wdensity[0][4])/(wdensity[0][5]-wdensity[0][4]));
               membershipvalues[1]=y;
   
     }
         if((x >= wdensity[0][6])&&( x<=wdensity[0][7])){
             y= (x-wdensity[0][6])/(wdensity[0][7]-wdensity[0][6]);
             membershipvalues[2]=y;}
         if((x >= wdensity[0][7])&&( x<=wdensity[0][8])) membershipvalues[2]=1;
    }
    public float min (float a,float b){
    if (a<=b)return a;
    else return b;
    }
    public float max (float a,float b){
    if (a>=b)return a;
    else return b;
    }
    public void savemem1(){
      System.arraycopy(membershipvalues, 0, mem1, 0, 3);
    }
    public void savemem2(){
      System.arraycopy(membershipvalues, 0, mem2, 0, 3);
    }
    public void rules2(){
    float miu0,miu1,miu2;
    if((mem1[0]!=0)&&(mem2[0]!=0)) {
        
    miu0=this.min(mem1[0], mem2[0]);
    truncval[0]=this.max(truncval[0],miu0);
    }
    if((mem1[0]!=0)&&(mem2[1]!=0)) {
    miu0=this.min(mem1[0], mem2[1]);
    truncval[0]=this.max(truncval[0],miu0);
    }
    if((mem1[1]!=0)&&(mem2[0]!=0)) {
    miu1=this.min(mem1[1], mem2[0]);
    truncval[1]=this.max(truncval[1],miu1);
    }
    if((mem1[1]!=0)&&(mem2[1]!=0)) {
    miu1=this.min(mem1[1], mem2[1]);
    truncval[1]=this.max(truncval[1],miu1);
    }
    if((mem1[2]!=0)&&(mem2[0]!=0)) {
    miu2=this.min(mem1[2], mem2[0]);
    truncval[2]=this.max(truncval[2],miu2);
    }
    if((mem1[2]!=0)&&(mem2[1]!=0)) {
    miu1=this.min(mem1[2], mem2[2]);
    truncval[1]=this.max(truncval[1],miu1);
    }
    if((mem1[2]!=0)&&(mem2[1]!=0)) {
    miu2=this.min(mem1[2], mem2[1]);
    truncval[2]=this.max(truncval[2],miu2);
    }
    
     if((mem1[2]!=0)&&(mem2[2]!=0)) {
    miu2=this.min(mem1[2], mem2[2]);
    truncval[2]=this.max(truncval[1],miu2);
    }
    }
    public void rules(){
    float miu0,miu1,miu2;
    if((mem1[0]!=0)&&(mem2[0]!=0)) {
        
    miu0=this.min(mem1[0], mem2[0]);
    truncval[0]=this.max(truncval[0],miu0);
    }
    if((mem1[0]!=0)&&(mem2[1]!=0)) {
    miu0=this.min(mem1[0], mem2[1]);
    truncval[0]=this.max(truncval[0],miu0);
    }
    if((mem1[1]!=0)&&(mem2[0]!=0)) {
    miu1=this.min(mem1[1], mem2[0]);
    truncval[1]=this.max(truncval[1],miu1);
    }
    if((mem1[1]!=0)&&(mem2[1]!=0)) {
    miu1=this.min(mem1[1], mem2[1]);
    truncval[1]=this.max(truncval[1],miu1);
    }
    if((mem1[2]!=0)&&(mem2[0]!=0)) {
    miu2=this.min(mem1[2], mem2[0]);
    truncval[2]=this.max(truncval[2],miu2);
    }
    if((mem1[2]!=0)&&(mem2[1]!=0)) {
    miu2=this.min(mem1[2], mem2[1]);
    truncval[2]=this.max(truncval[2],miu2);
    }
     if((mem1[2]!=0)&&(mem2[1]!=0)) {
    miu1=this.min(mem1[2], mem2[2]);
    truncval[1]=this.max(truncval[1],miu1);
    }
     if((mem1[2]!=0)&&(mem2[2]!=0)) {
    miu2=this.min(mem1[2], mem2[2]);
    truncval[2]=this.max(truncval[2],miu2);
    }
    }
    //defuzzification------
    public float defuzz(){
    float rez ,r1,r2,r3,r,s,t1,t2,t3,g1,g2,g3;
    t1=truncval[0];
    t2=truncval[1];
    t3=truncval[2];
    g1=green[0][1];
    g2=green[0][4];
    g3=green[0][7];
    r=t1*g1+t2*g2+t3*g3;
     s=t1+t2+t3;
    rez=r/s;
    System.out.print(" green time is :");
    System.out.println(rez);
    return rez;
    }
    public float defuzz2(){
    float rez ,r1,r2,r3,r,s,t1,t2,t3,g1,g2,g3;
    t1=truncval[0];
    t2=truncval[1];
    t3=truncval[2];
    g1=green2[0][1];
    g2=green2[0][4];
    g3=green2[0][7];
    r=t1*g1+t2*g2+t3*g3;
     s=t1+t2+t3;
    rez=r/s;
    System.out.print(" green time is :");
    System.out.println(rez);
    return rez;
    }
    //---applying fuzzy algorithm ---
    public float fuzzify2val(float x,float y){
    this.getmembership(x);
    this.savemem1();
    this.getmembership(y);
    this.savemem2();
    this.rules();
    return this.defuzz();
    }
    
    public float fuzzify2val2(float x,float y){
    this.getmembership(x);
    this.savemem1();
    this.getmembership(y);
    this.savemem2();
    this.rules2();
    return this.defuzz2();
    }
    public void main (){
    System.out.println("tut");
    }
}
