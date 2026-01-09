#include <iostream>
#include "Math271.h"
#include <cstdio>
int main() {
     for (int i = 0; i < 1000; i++) {
            printf("%d:%.16f\n",i, Math271::sqrt(i,32)) ;
     }
    
    return 0;
}