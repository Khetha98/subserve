import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule, RouterLink],
  templateUrl: './navbar.html',
  styleUrl: './navbar.scss',
})
export class Navbar {

  isMenuOpen = false
  isLoggedIn = false

  constructor(private authService: AuthService,
    private router: Router
  ) {
  }

  ngOnInit() {

    this.authService.isLoggedIn$.subscribe(state => {
      this.isLoggedIn = state
    })

  }

  toggleMenu() {
    this.isMenuOpen = !this.isMenuOpen
  }

  changeCurrency(currency: string) {
    console.log('Currency changed to', currency)
  }

  logout() {

    this.authService.logout()

    this.router.navigate(['/'])

  }

  goHome(){
  this.router.navigateByUrl('/', { skipLocationChange: false }).then(() => {
    this.router.navigate(['/']);
  });
}

}