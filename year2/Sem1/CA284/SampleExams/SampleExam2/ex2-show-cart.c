#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


typedef struct Cart Cart;
struct Cart
{
    char Item[20];
    int amount;
    float price;
    char promo[10];
};

void createCart(Cart *cart, char *argv[], int numCarts);
void printCart(Cart *cart);
void onSale(Cart *cart);

int main(int argc, char*argv[])
{
    int numCarts = (argc - 1) / 4;
    struct Cart cart[numCarts];
    createCart(cart, argv, numCarts);
    for (int i = 0; i < numCarts; ++i)
    {
        onSale(&cart[i]);
    }
    for (int i = 0; i < numCarts; ++i)
    {
        printCart(&cart[i]);
    }
}

void createCart(Cart *cart, char *argv[], int numCarts)
{
    int index = 1;
    for (int i = 0; i < numCarts; ++i)
    {
        strcpy(cart[i].Item, argv[index]);
        cart[i].amount = atoi(argv[index + 1]);
        cart[i].price = atof(argv[index + 2]);
        strcpy(cart[i].promo, argv[index + 3]);

        index += 4;
    }
}

void printCart(Cart *cart)
{
    printf("%s,", cart->Item);
    printf("%d,", cart->amount);
    printf("%.2f,", cart->price);
    printf("%s\n", cart->promo);
}

void onSale(Cart *cart)
{
    if (atoi(cart->promo) == 1)
    {
        strcpy(cart->promo, "On Sale");
    }
    else
    {
        strcpy(cart->promo, "No Sale");
    }
}