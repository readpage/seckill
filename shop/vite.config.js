import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    port: 3001,
    proxy: {
      "/api": {
        target: "http://localhost:80/",
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, '')
      },
    }
  },
  // 打包
  build: {
     // 指定输出路径（相对于 项目根目录).
    outDir: "shop",
    // 指定生成静态资源的存放路径（相对于 build.outDir）。
    assetsDir: "assets",
  }
})
