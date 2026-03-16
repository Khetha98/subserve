import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './register.html',
  styleUrl: './register.scss',
})
export class Register {

  private fb = inject(FormBuilder); 

registerForm = this.fb.group({

  fullName: ['', Validators.required],

  email: ['', [Validators.required, Validators.email]],

  phone: [''],

  role: ['CUSTOMER', Validators.required],

  password: ['', [Validators.required, Validators.minLength(6)]]

})

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

register() {

  if (this.registerForm.invalid) return

  this.authService.register(this.registerForm.value).subscribe({

    next: () => {
      this.router.navigate(['/login'])
    },

    error: err => console.error(err)

  })

}

}
