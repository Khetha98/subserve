import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule, RouterLink],
  templateUrl: './navbar.html',
  styleUrl: './navbar.scss',
})
export class Navbar {

  isMenuOpen = false;
  isLoggedIn = false;   // temporary until auth system exists

  toggleMenu() {
    this.isMenuOpen = !this.isMenuOpen;
  }

  changeCurrency(currency: string) {
    console.log('Currency changed to', currency);
  }

  onSearch(term: string) {
    console.log('Search:', term);
  }
}