import { Component } from '@angular/core';
import { Footer } from '../../components/footer/footer';
import { Navbar } from '../../components/navbar/navbar';

@Component({
  selector: 'app-delivery',
  imports: [Footer,
    Navbar
  ],
  templateUrl: './delivery.html',
  styleUrl: './delivery.scss',
})
export class DeliveryComponent {}
