import { Component } from '@angular/core';
import { Footer } from '../../components/footer/footer';
import { CommonModule } from '@angular/common'; 
import { Navbar } from '../../components/navbar/navbar';

@Component({
  selector: 'app-home',
  imports: [Footer,
    CommonModule,
    Navbar
  ],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class HomeComponent {}
