#include <iostream>
#include "Math271.h"
#include <cstdio>
#include "math.h"
int main()
{

       for (int i = 0; i < 100000000; i++)
       {
              Math271::sqrt(i, 2);
       }

       for (int i = 0; i < 100000000; i++)
       {
              sqrt(i);
       }

       return 0;
}