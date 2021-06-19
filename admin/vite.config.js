import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  // css: {
  //   preprocessorOptions: {
  //     scss: {
  //       additionalData: "@import './src/assets/css/common.scss';"
  //     }
  //   }
  // },
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:80/',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, '')
      },
    }
  },
  build: {
     // 打包输出文件目录
     outDir: "admin",
    //静态资源文件目录
    assetsDir: "assets",
  }
})
