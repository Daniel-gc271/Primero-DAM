#include <iostream>
#include "Math271.h"
#include <cstdio>
int main() {
     for (int i = 0; i < 100000000; i++) {
            printf("%d:%.16f",i, Math271::sqrt(i,2)) ;
            system("cls");
     }
    
    return 0;
}