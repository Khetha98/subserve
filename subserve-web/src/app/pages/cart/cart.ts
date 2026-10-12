import { Component } from '@angular/core';
import { Footer } from '../../components/footer/footer';
import { Navbar } from '../../components/navbar/navbar';
import { CartWidget } from '../../components/cart-widget/cart-widget';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-cart',
  imports: [
    CartWidget,
    RouterLink
  ],
  templateUrl: './cart.html',
  styleUrl: './cart.scss',
})
export class CartComponent {}
