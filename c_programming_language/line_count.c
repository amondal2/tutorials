#include <stdio.h>

main() {
    int count, c;
    while ((c = getchar()) != EOF) {
        if (c == '\n') {
            ++count;
        }
    }
    printf("%d\n", count);
}