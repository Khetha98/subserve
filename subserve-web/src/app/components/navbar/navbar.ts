import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  imports: [],
  templateUrl: './navbar.html',
  styleUrl: './navbar.scss',
})
export class Navbar {
    changeCurrency(currency: string) {
    console.log('Currency changed to', currency);
    // later connect to CurrencyService
  }

  onSearch(term: string) {
    console.log('Search:', term);
    // later route to /products?search=term
  }
}
