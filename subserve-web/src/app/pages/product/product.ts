import { Component } from '@angular/core';
import { Footer } from '../../components/footer/footer';
import { Navbar } from '../../components/navbar/navbar';
import { ProductModel } from '../../interfaces/product.model';
import { ProductService } from '../../services/product.service';
import { CommonModule } from '@angular/common';
import { ProductCardComponent } from '../../components/product-card/product-card';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-product',
  imports: [
    CommonModule,
    ProductCardComponent,
  ],
  templateUrl: './product.html',
  styleUrl: './product.scss',
})
export class ProductComponent {


  products$!: Observable<any>;
  constructor(public productService: ProductService) {
    console.log("called product constructor!!");
  }

  ngOnInit() {
    this.products$ = this.productService.getProducts();
      this.products$.subscribe({
    next: data => console.log("DATA RECEIVED:", data),
    error: err => console.error("ERROR:", err),
    complete: () => console.log("COMPLETED")
  });
  }

}
