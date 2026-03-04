import { Component } from '@angular/core';
import { Footer } from '../../components/footer/footer';
import { CommonModule } from '@angular/common'; 
import { Navbar } from '../../components/navbar/navbar';
import { ProductModel } from '../../interfaces/product.model';
import { ProductService } from '../../services/product.service';
import { ProductCardComponent } from '../../components/product-card/product-card';
import { CLIENT_RENEG_LIMIT } from 'tls';

@Component({
  selector: 'app-home',
  imports: [Footer,
    CommonModule,
    Navbar,
    ProductCardComponent
  ],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class HomeComponent {

  constructor(private productService: ProductService) {}

  products: ProductModel[] = [];

  ngOnInit() {
    this.productService.getProducts().subscribe(data => {
      this.products = data;
      console.log("products are:", this.products);
    });
  }
}
