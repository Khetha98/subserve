import { Component } from '@angular/core';
import { Footer } from '../../components/footer/footer';
import { Navbar } from '../../components/navbar/navbar';
import { ProductModel } from '../../interfaces/product.model';
import { ProductService } from '../../services/product.service';
import { CommonModule } from '@angular/common';
import { ProductCardComponent } from '../../components/product-card/product-card';

@Component({
  selector: 'app-product',
  imports: [
    CommonModule,
    ProductCardComponent
  ],
  templateUrl: './product.html',
  styleUrl: './product.scss',
})
export class ProductComponent {

  products: ProductModel[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.productService.getProducts().subscribe(data => {
      this.products = data;
      console.log(data);
    });
  }

}
