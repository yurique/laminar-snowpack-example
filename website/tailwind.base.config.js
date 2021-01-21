module.exports = {
  prefix: '',
  future: {
    removeDeprecatedGapUtilities: true,
    purgeLayersByDefault: true,
  },
  important: false,
  separator: ':',
  experimental: {
    uniformColorPalette: true,
  },
  theme: {
    extend: {
      fontFamily: {
        serif: ['Inter', 'ui-serif', 'Georgia', 'Cambria', '"Times New Roman"', 'Times', 'serif'],
      },
    },
  },
  corePlugins: {},
  plugins: [
    require('@tailwindcss/ui'),
  ],
}
