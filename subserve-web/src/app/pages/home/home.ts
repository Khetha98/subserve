import { Component } from '@angular/core';
import { Footer } from '../../components/footer/footer';
import { CommonModule } from '@angular/common'; 
import { Navbar } from '../../components/navbar/navbar';
import { ProductModel } from '../../interfaces/product.model';
import { ProductService } from '../../services/product.service';
import { ProductCardComponent } from '../../components/product-card/product-card';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [
    CommonModule,
    ProductCardComponent,
    RouterLink
  ],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class HomeComponent {

  products: ProductModel[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.productService.getProducts().subscribe(data => {
      this.products = data;
      console.log(data);
    });
  }

}
