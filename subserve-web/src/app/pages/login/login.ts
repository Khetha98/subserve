import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {

  private fb = inject(FormBuilder); 
  
  loginForm = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required]]
  })

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  login() {
    if (this.loginForm.invalid) return;

    this.authService.login(
      this.loginForm.value.email!,
      this.loginForm.value.password!
    ).subscribe({
      next: (response: any) => {
        // Optional: Check user role returned from backend auth service to redirect admins to admin dashboard
        if (response && response.role === 'ADMIN') {
          this.router.navigate(['/admin/dashboard']);
        } else {
          this.router.navigate(['/']);
        }
      },
      error: err => {
        console.error('Login error:', err);
      }
    });
  }
}