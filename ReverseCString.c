#include<stdio.h>

int main(void){
  char string[] = "abcd";
  char* s = string;
  char* end = s;
  char tmp;

//  printf("s in int: %i\n",(int)s);
//  if(s){
    while(*end){
      end++;
    }
     if(*end){
      printf("end value true.\n");
    }else{
      printf("end value false.\n");
    }
    
  //  printf("end of string pointer in int: %i\n",(int)end);
    end--;
   // printf("end is: %s\n", end);
    while(s<end){
    //  printf("inside while\n");
      tmp = *s;
      *s++ = *end;
      *end-- = tmp;
    }
   // printf("after reversing\n");
 // }
  printf("%s\n", string);
}