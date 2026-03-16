import { Injectable, Inject, PLATFORM_ID } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { Observable, BehaviorSubject, tap } from 'rxjs'
import { isPlatformBrowser } from '@angular/common'

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private api = 'http://localhost:9091/api/auth'

  private isBrowser: boolean

  private loggedIn = new BehaviorSubject<boolean>(false)
  isLoggedIn$ = this.loggedIn.asObservable()

  constructor(
    private http: HttpClient,
    @Inject(PLATFORM_ID) platformId: Object
  ) {

    this.isBrowser = isPlatformBrowser(platformId)

    if (this.isBrowser) {
      this.loggedIn.next(this.hasToken())
    }

  }

  login(email: string, password: string): Observable<any> {

    return this.http.post<any>(`${this.api}/login`, { email, password })
      .pipe(
        tap(res => {

          if (this.isBrowser) {
            localStorage.setItem('token', res.token)
          }

          this.loggedIn.next(true)

        })
      )

  }

  register(payload: any) {
    return this.http.post(`${this.api}/register`, payload)
  }

  logout() {

    if (this.isBrowser) {
      localStorage.removeItem('token')
    }

    this.loggedIn.next(false)
  }

  hasToken(): boolean {

    if (!this.isBrowser) return false

    return !!localStorage.getItem('token')

  }

  getToken() {

    if (!this.isBrowser) return null

    return localStorage.getItem('token')

  }

}