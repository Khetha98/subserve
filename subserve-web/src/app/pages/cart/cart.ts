import { Component } from '@angular/core';
import { Footer } from '../../components/footer/footer';
import { Navbar } from '../../components/navbar/navbar';
import { CartWidget } from '../../components/cart-widget/cart-widget';

@Component({
  selector: 'app-cart',
  imports: [
    CartWidget
  ],
  templateUrl: './cart.html',
  styleUrl: './cart.scss',
})
export class CartComponent {}
