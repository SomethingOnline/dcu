#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct Cart Cart;
struct Cart {
    char Item[20];
    int amount;
    float price;
    char promo[10];
};

void createCart(Cart *cart, char *argv[], int numCarts);
void onSale(Cart *cart);
void ifSale(Cart *cart);

int main(int argc, char *argv[]) {
    int numCarts = (argc - 1) / 4;
    struct Cart cart[numCarts];
    createCart(cart, argv, numCarts);

    for (int i = 0; i < numCarts; ++i) {
        onSale(&cart[i]);
    }

    float sum = 0;
    for (int i = 0; i < numCarts; ++i) {
        ifSale(&cart[i]);
        sum += (cart[i].price) * (cart[i].amount);
    }

    if (sum == (int)sum)
    {
        printf("%d\n", (int)sum);
    }
    else
    {
        printf("%.2f\n", sum);
    }
}

void createCart(Cart *cart, char *argv[], int numCarts) {
    int index = 1;
    for (int i = 0; i < numCarts; ++i) {
        strcpy(cart[i].Item, argv[index]);
        cart[i].amount = atoi(argv[index + 1]);
        cart[i].price = atof(argv[index + 2]);
        strcpy(cart[i].promo, argv[index + 3]);

        index += 4;
    }
}

void ifSale(Cart *cart) {
    if (strcmp(cart->promo, "On Sale") == 0) 
    {
        int items = cart->amount;
        int paid = (((items / 3) * 2)) + ((items % 3));
        cart->amount = paid;
    }
}

void onSale(Cart *cart) {
    if (atoi(cart->promo) == 1) {
        strcpy(cart->promo, "On Sale");
    } else {
        strcpy(cart->promo, "No Sale");
    }
}
